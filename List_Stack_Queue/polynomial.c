#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "polynomial.h"

struct Node {
    ElementType coefficient;
    ElementType exponent;
    Position next;
};

Polynomial combine_sim_polynomial(Polynomial poly);

Polynomial make_empty(Polynomial poly) {
    if (poly != NULL) { delete_list(poly); }

    poly = (Polynomial)malloc(sizeof(struct Node));
    if (poly == NULL) {
        printf("No Space, quit!\n");
        exit(1);
    }
    poly->next = NULL;
    return poly;
}

bool is_empty(Polynomial poly) {
    return poly->next == NULL;
}

bool is_last(Position pos) {
    return pos->next == NULL;
}

Position first(Polynomial poly) {
    return poly->next;
}

Position header(Polynomial poly) {
    return poly;
}

void delete_list(Polynomial poly) {
    Position pos;
    Position temp;

    pos = first(poly);
    while (pos != NULL) {
        temp = advance(pos);
        free(pos);
        pos = temp;
    }
}

void insert(ElementType coeff, ElementType expon, Position p) {
    Position temp = (Polynomial)malloc(sizeof(struct Node));
    if (temp == NULL) {
        printf("No Space, quit!\n");
        exit(1);
    }
    temp->coefficient = coeff;
    temp->exponent = expon;
    temp->next = p->next;
    p->next = temp;
}

Position advance(Position p) {
    return p->next;
}

void print_list(Polynomial poly) {
    Position p;

    if (is_empty(poly)) {
        printf("No Data\n");
    } else {
        p = first(poly);
        while (p != NULL) {
            if (p->coefficient != 0) {
                if (p->exponent == 0) {
                    printf("%d", p->coefficient);
                } else if (p->next != NULL && p->next->coefficient > 0) {
                    printf("%d^%d+", p->coefficient, p->exponent);
                } else {
                    printf("%d^%d", p->coefficient, p->exponent);
                }
            }
            p = advance(p);
        }
        printf("\n");
    }
}

void list_insert_sort(Polynomial head) {
    Polynomial head1;
    Position p, q, temp;

    if (head->next == NULL || head->next->next == NULL) {
        return;
    } else {
        head1 = head->next->next;
        head->next->next = NULL;

        while (head1 != NULL) {
            for (p = first(head), q = header(head); p != NULL && head1->exponent < p->exponent; q = p, p = p->next) {
                continue;
            }
            temp = head1;
            head1 = head1->next;
            q->next = temp;
            temp->next = p;
        }
    }
}

Polynomial add_polynomial(const Polynomial poly1, const Polynomial poly2, Polynomial poly_sum) {
    Position p1 = first(poly1);
    Position p2 = first(poly2);

    poly_sum = make_empty(NULL);
    Position p = header(poly_sum);
    while (p1 != NULL && p2 != NULL) {
        if (p1->exponent < p2->exponent) {
            insert(p2->coefficient, p2->exponent, p);
            p2 = advance(p2);
        } else if (p1->exponent > p2->exponent) {
            insert(p1->coefficient, p1->exponent, p);
            p1 = advance(p1);
        } else {
            insert(p1->coefficient + p2->coefficient, p1->exponent, p);
            p1 = advance(p1);
            p2 = advance(p2);
        }
        p = advance(p);
    }

    while (p1 != NULL) {
        insert(p1->coefficient, p1->exponent, p);
        p1 = advance(p1);
        p = advance(p);
    }

    while (p2 != NULL) {
        insert(p2->coefficient, p2->exponent, p);
        p2 = advance(p2);
        p = advance(p);
    }

    return poly_sum;
}

Polynomial mul_polynomial(const Polynomial poly1, const Polynomial poly2, Polynomial poly_prod) {
    poly_prod = make_empty(NULL);

    Position p = header(poly_prod);
    Position p1 = first(poly1);
    Position p2 = first(poly2);

    while (p1 != NULL) {
        while (p2 != NULL) {
            insert((p1->coefficient * p2->coefficient), (p1->exponent + p2->exponent), p);
            p = advance(p);
            p2 = advance(p2);
        }
        p1 = advance(p1);
        p2 = first(poly2);
    }
    list_insert_sort(poly_prod);
    poly_prod = combine_sim_polynomial(poly_prod);
    return poly_prod;
}

Polynomial combine_sim_polynomial(Polynomial poly) {
    if (poly == NULL || poly->next->next == NULL) {
        return poly;
    } else {
        Position p = poly->next;
        Position q = p->next;
        while (q != NULL) {
            if (p->exponent == q->exponent) {
                p->coefficient += q->coefficient;
                p->next = q->next;
                q = q->next;
            } else {
                p = p->next;
                q = q->next;
            }
        }
        return poly;
    }
}