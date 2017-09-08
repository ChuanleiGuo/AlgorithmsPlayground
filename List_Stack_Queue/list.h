#ifndef _List_H

struct Node;
typedef struct Node *Ptr_Node;
typedef Ptr_Node List;
typedef Ptr_Node Position;
typedef int Element_Type;

List make_empty(List l);
int is_empty(List l);
int is_last(Position p, List l);
Position find(Element_Type x, List l);
void delete_node(Element_Type x, List l);
Position find_previous(Element_Type x, List l);
void insert_node(Element_Type x, List l, Position p);
void delete_list(List l);
Position header(List l);
Position first(List l);
Position advance(Position p);
Element_Type retrieve(Position p);

#endif