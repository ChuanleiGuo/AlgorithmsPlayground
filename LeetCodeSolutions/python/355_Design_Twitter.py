import heapq

class Twitter(object):
    time_stamp = 0

    class Tweet(object):

        def __init__(self, tid):
            self.tid = tid
            self.time = Twitter.time_stamp
            Twitter.time_stamp += 1
            self.next_tweet = None

    class User(object):

        def __init__(self, uid):
            self.uid = uid
            self.followed = set()
            self.follow(uid)
            self.tweet_head = None

        def follow(self, uid):
            self.followed.add(uid)

        def unfollow(self, uid):
            self.followed.remove(uid)

        def post(self, tid):
            tweet = Twitter.Tweet(tid)
            tweet.next_tweet = self.tweet_head
            self.tweet_head = tweet

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.user_map = {}

    def postTweet(self, userId, tweetId):
        """
        Compose a new tweet.
        :type userId: int
        :type tweetId: int
        :rtype: void
        """
        if userId not in self.user_map:
            user = Twitter.User(userId)
            self.user_map[userId] = user
        self.user_map[userId].post(tweetId)


    def getNewsFeed(self, userId):
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        :type userId: int
        :rtype: List[int]
        """
        res = []
        if userId not in self.user_map:
            return res

        users = self.user_map[userId].followed
        priority_queue = []

        for user in users:
            t = self.user_map[user].tweet_head
            if t:
                heapq.heappush(priority_queue, (-t.time, t))

        n = 0
        while len(priority_queue) != 0 and n < 10:
            neg_time, tweet = heapq.heappop(priority_queue)
            res.append(tweet.tid)
            n += 1
            if tweet.next_tweet:
                heapq.heappush(priority_queue, (-tweet.next_tweet.time, tweet.next_tweet))

        return res

    def follow(self, followerId, followeeId):
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        if followerId not in self.user_map:
            user = Twitter.User(followerId)
            self.user_map[followerId] = user

        if followeeId not in self.user_map:
            user = Twitter.User(followeeId)
            self.user_map[followeeId] = user

        self.user_map[followerId].follow(followeeId)

    def unfollow(self, followerId, followeeId):
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        if followerId not in self.user_map or followeeId == followerId:
            return
        if followeeId in self.user_map[followerId].followed:
            self.user_map[followerId].unfollow(followeeId)
