#include "list.h"
#include <stdio.h>
#include <stdlib.h>

struct Node {
    Element_Type element;
    Position next;
};

/* Return true if L is empty */
int is_empty(List l) {
    return l->next == NULL;
}

/*
Return true if p is the last position in list l,
Parameter l is unused in the implementation
*/
int is_last(Position p, List l) {
    return p->next == NULL;
}

/* Return Position of x in l. NULL if not found */
Position find(Element_Type x, List l) {
    Position p = l->next;
    while (p && p->element != x) {
        p = p->next;
    }
    return p;
}

/* Delete first occurance of x from a list */
void delete_node(Element_Type x, List l) {
    Position p, tmp_cell;
    p = find_previous(x, l);
    if ( !is_last(p, l) ) {
        tmp_cell = p->next;
        p->next = tmp_cell->next;
        free(tmp_cell);
    }
}

/* If x is not found, then next field of returned position is NULL */
Position find_previous(Element_Type x, List l) {
    Position p;
    p = l;
    while (p->next && p->next->element != x) {
        p = p->next;
    }
    return p;
}

/* Insert after position p */
void insert_node(Element_Type x, List l, Position p) {
    Position tmpCell;

    tmpCell = (Ptr_Node)malloc(sizeof(struct Node));
    if (tmpCell == NULL){
        perror("Out of memory\n");
    }
    tmpCell->element = x;
    tmpCell->next = p->next;
    p->next = tmpCell;
}

/* Delete List */
void delete_list(List l) {
    Position p, tmp;
    p = l->next;
    l->next = NULL;
    while (p != NULL) {
        tmp = p->next;
        free(p);
        p = tmp;
    }
}
