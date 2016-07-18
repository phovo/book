
 set database sql syntax ORA true;
 
 create schema book_core authorization dba;
 
 /* ---------------------------------------------------------------------- */
/* Tables                                                                 */
/* ---------------------------------------------------------------------- */
 
 
/* ---------------------------------------------------------------------- */
/* Add table "user"                                     */
/* ---------------------------------------------------------------------- */ 
 
CREATE TABLE book_core.user (
    id INTEGER IDENTITY,
    email VARCHAR(16) CONSTRAINT user_nn1 NOT NULL,
    password VARCHAR2(128) CONSTRAINT user_nn2 NOT NULL,
    firstname VARCHAR2(128),
    lastname VARCHAR2(128)
); 

/* ---------------------------------------------------------------------- */
/* Add table "book"                                     */
/* ---------------------------------------------------------------------- */ 
CREATE TABLE book_core.book (
    id INTEGER IDENTITY,
    title VARCHAR2(128) CONSTRAINT book_nn1 NOT NULL,
    author VARCHAR2(128) CONSTRAINT book_nn2 NOT NULL,
    date_create DATE CONSTRAINT book_nn3 NOT NULL,
    date_update DATE,
    description VARCHAR2(128)
);

/* ---------------------------------------------------------------------- */
/* view table "book"                                     */
/* ---------------------------------------------------------------------- */ 
CREATE VIEW book_core.book_view AS
SELECT v.id,
       v.title,
       v.author,
       v.description
FROM book_core.book v;
