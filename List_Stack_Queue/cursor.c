#include "cursor.h"
#include <stdio.h>
#include <stdlib.h>

struct Node {
    ElementType element;
    Position next;
};

const int SpaceSize = 1000;

struct Node CursorSpace[SpaceSize];

static Position cursor_alloc(void) {
    Position p;
    p = CursorSpace[0].next;
    CursorSpace[0].next = CursorSpace[p].next;
    return p;
}

static void cursor_free(Position p) {
    CursorSpace[p].next = CursorSpace[0].next;
    CursorSpace[0].next = p;
}

int is_empty(List l) {
    return CursorSpace[l].next == 0;
}

int is_last(Position p, List l) {
    return CursorSpace[p].next == 0;
}

Position find(ElementType x, List l) {
    Position p;
    p = CursorSpace[l].next;
    while (p && CursorSpace[p].element != x) {
        p = CursorSpace[p].next;
    }
    return p;
}

void delete_node(ElementType x, List l) {
    Position p, tmp_cell;
    p = find_previous(x, l);
    if (!is_last(p, l)) {
        tmp_cell = CursorSpace[p].next;
        CursorSpace[p].next = CursorSpace[tmp_cell].next;
        cursor_free(tmp_cell);
    }
}

void insert_node(ElementType x, List l, Position p) {
    Position tmp_cell;
    tmp_cell = cursor_alloc();
    if (tmp_cell == 0) {
        perror("Out of memory\n");
    }
    CursorSpace[tmp_cell].element = x;
    CursorSpace[tmp_cell].next = CursorSpace[p].next;
    CursorSpace[p].next = CursorSpace[tmp_cell].next;
}