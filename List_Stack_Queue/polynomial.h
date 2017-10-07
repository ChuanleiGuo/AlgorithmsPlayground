typedef int ElementType;

#ifndef _POLYNOMIAL_H
#define _POLYNOMIAL_H

struct Node;
typedef struct Node *PtrToNode;
typedef PtrToNode Polynomial;
typedef PtrToNode Position;

Polynomial make_empty(Polynomial poly);
bool is_empty(Polynomial poly);
bool is_last(Position pos);
Position first(Polynomial poly);
Position header(Polynomial poly);
void delete_list(Polynomial poly);
void insert(ElementType coeff, ElementType expon, Position pos);
Position advance(Position pos);
void print_list(Polynomial poly);
void list_insert_sort(Polynomial head);
Polynomial add_polynomial(const Polynomial poly1, const Polynomial poly2, Polynomial poly_sum);
Polynomial mul_polynomial(const Polynomial poly1, const Polynomial poly2, Polynomial poly_prod);
#endif
