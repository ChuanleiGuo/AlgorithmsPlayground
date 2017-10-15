#ifndef _Cursor_H

typedef int PtrToNode;
typedef PtrToNode List;
typedef PtrToNode Position;
typedef int ElementType;

void InitializeCursorSpace(void);

List make_empty(List l);
int is_empty(List l);
int is_last(Position p, List l);
Position find(ElementType x, List l);
void delete_node(ElementType x, List l);
Position find_previous(ElementType x, List l);
void insert_node(ElementType x, List l, Position p);
void delete_list(List l);
Position header(List l);
Position first(List l);
Position advance(Position p);
ElementType retrieve(Position p);

#endif