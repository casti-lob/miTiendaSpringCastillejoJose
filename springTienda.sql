CREATE DATABASE miTiendaSpringCastillejoJose;

CREATE USER 'castillejoJose'@'%' IDENTIFIED BY 'castillejoJose';

GRANT ALL PRIVILEGES ON miTiendaSpringCastillejoJose.* to 'castillejoJose'@'%';


CREATE TABLE miTiendaSpringCastillejoJose.category(
id INT(6) AUTO_INCREMENT,
name VARCHAR(20),
description VARCHAR(500),

CONSTRAINT PK_CATEGORY PRIMARY KEY (id)
);

CREATE TABLE  miTiendaSpringCastillejoJose.article (
id INT(6) AUTO_INCREMENT,
title VARCHAR(150) unique,
description VARCHAR(500),
price REAL,
id_category INT(6),
stock INT(5),

CONSTRAINT PK_ARTICLE PRIMARY KEY (id),
CONSTRAINT FK_ARTICLE FOREIGN KEY (id_category) REFERENCES category(id) ON DELETE CASCADE
);



CREATE TABLE miTiendaSpringCastillejoJose.user(
user VARCHAR(20),
password VARCHAR(33),
name VARCHAR(20),
email VARCHAR(100),
admin boolean,
CONSTRAINT PK_USER PRIMARY KEY (user)
);
CREATE TABLE miTiendaSpringCastillejoJose.orders(
  id INT(6) AUTO_INCREMENT,
    user VARCHAR(20),
    dateuser date,
    iva real,
   CONSTRAINT PK_ORDER PRIMARY KEY (id),
    CONSTRAINT FK_ORDER FOREIGN KEY (user) REFERENCES user(user) ON DELETE CASCADE
);
    
CREATE TABLE miTiendaSpringCastillejoJose.cart(
idorder INT(6),
idaricle INT(6),
number INT(11),
price real,
datecart DATETIME,

CONSTRAINT PK_CART PRIMARY KEY (idaricle,idorder,datecart),
CONSTRAINT FK_CART FOREIGN KEY (idaricle) REFERENCES article (id) ON DELETE CASCADE,
CONSTRAINT FK2_CART FOREIGN KEY (idorder) REFERENCES orders(id) ON DELETE CASCADE
);


INSERT INTO miTiendaSpringCastillejoJose.user (user, password, name, email, admin) VALUES ('inma', md5('inma'), 'Inma', 'inma@hotmail.com', '1');
INSERT INTO miTiendaSpringCastillejoJose.user (user, password, name, email, admin) VALUES ('jose', md5('jose'), 'Jose', 'jose@hotmail.com', '0');


INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'Accion', 'En este género prevalecen altas dosis de adrenalina con una buena carga de movimiento, fugas, acrobacias, peleas, guerras, persecuciones y una lucha contra el mal.');
INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'Aventuras', 'Similares a las de acción, predominan las nuevas experiencias y situaciones.');
INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'Ciencia Ficción', 'Basados en fenómenos imaginarios, en la ciencia ficción son usuales los extraterrestres, sociedades inventadas, otros planetas.');
INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'Comedia', 'Diseñadas específicamente para provocar la risa o la alegría entre los espectadores.');
INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'No-Ficción', ' Este género analiza un hecho o situación real sin ficcionarlo.');
INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'Drama', 'Los dramas se centran en desarrollar el problema o problemas entre los diferentes protagonistas. Este es quizás uno de los géneros cinematográficos más amplios de la lista. No predominan las aventuras o la acción, aunque pueden aparecer puntualmente Generalmente se basan en desarrollar la interacción y caracteres humanos.');
INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'Fantasía', 'En ellas se incluyen personajes irreales o totalmente inventados, inexistentes en nuestra realidad. También podemos conocer este género de cine como “fantástico”. No se basa en ideas que puedan llegar a materializarse.');
INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'Musical', 'Las películas que cortan su desarrollo natural con fragmentos musicales son protagonistas de este género.');
INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'Suspense', 'Conocido también como intriga, estas películas se desarrollan rápidamente, y todos sus elementos giran entorno un mismo elemento intrigante.');
INSERT INTO miTiendaSpringCastillejoJose.category ( name, description) VALUES ( 'Terror', 'Su principal objetivo es causar miedo, horror, incomodidad o preocupación.');




insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Doomsday Prophecy', 'Abn cytolog findings in specmn from oth dgstv org/abd cav', 23.62, 7, 23);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('I Spit on Your Grave', 'Oth complications following immunization, NEC', 30.01, 5, 25);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Early Spring (Soshun)', 'Other superficial bite of right thumb', 15.16, 7, 97);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Easy Street', 'Pressure ulcer of right heel, stage 1', 51.46, 3, 71);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Incredibly Strange Creatures Who Stopped Living and Became Mixed-Up Zombies!!?, The', 'Displ commnt suprcndl fx w/o intrcndl fx l humer, 7thG', 38.67, 9, 79);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Now and Then', 'Unsp fx fifth MC bone, right hand, subs for fx w malunion', 31.31, 5, 100);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Matti: Hell Is for Heroes (Matti)', 'Disp fx of medial phalanx of l little fngr, init for opn fx', 15.17, 9, 48);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Stoplight Society, The (La Sociedad del Semáforo)', 'Unspecified fracture of left pubis', 29.38, 3, 49);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Rebound, The', 'Unsp fx fourth MC bone, right hand, subs for fx w malunion', 13.69, 4, 100);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Little Men', 'Contusion of left hand, sequela', 45.63, 3, 94);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Gummo', 'Alcohol dependence with alcohol-induced sexual dysfunction', 49.04, 7, 67);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Somersault', 'Aneurysmal bone cyst, upper arm', 31.41, 3, 91);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('My Fair Lady', 'Chronic gout due to renal impairment, right hand, w tophus', 42.14, 6, 41);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Killer Pad', 'Athscl autologous artery CABG w oth angina pectoris', 16.45, 1, 38);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Wieners', 'Occ of pk-up/van injured in trnsp acc w miltry vehicle, init', 39.95, 5, 88);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Top Five', 'Abscess of bursa, hip', 24.3, 5, 15);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Last Chance', 'Synovial hypertrophy, NEC, left ankle and foot', 39.36, 2, 65);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Batman', 'Self-harm by rifle, shotgun and larger firearm discharge', 23.14, 1, 27);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('The Night That Panicked America', 'Traumatic anuria, initial encounter', 21.15, 10, 20);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Snowball Effect: The Story of ''Clerks''', 'Complete loss of teeth due to caries, unspecified class', 19.48, 6, 8);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Heavy Metal in Baghdad', 'Oth fx upper end of unsp radius, subs for clos fx w malunion', 47.75, 2, 99);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Angel in My Pocket', 'Paralytic calcifcn and ossification of muscle, unsp site', 42.41, 2, 80);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Sleepwalk with Me', 'Maternal care for other malpresentation of fetus', 20.26, 9, 55);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Heavy Metal', 'Other forms of actinomycosis', 22.79, 4, 76);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Under Suspicion', 'Post-traumatic osteoarthritis, unspecified shoulder', 15.03, 8, 92);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Kalifornia', 'Poisoning by unsp fibrin-affct drugs, intentional self-harm', 23.09, 9, 85);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('River''s Edge', 'Post disp fx of sternal end unsp clavicle, 7thK', 43.95, 6, 87);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Lucky Numbers', 'Toxic effect of unsp halgn deriv of aromat hydrocrb, slf-hrm', 42.54, 2, 69);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Ladies vs. Ricky Bahl', 'Unsp infct of urinary tract in pregnancy, first trimester', 49.34, 9, 20);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Game Plan, The', 'Partial traumatic amputation of nose, sequela', 49.64, 4, 43);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Jubilation Street', 'Specific reading disorder', 29.78, 5, 47);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Jab We Met', 'Cocaine abuse w cocaine-induc psychotic disorder w hallucin', 29.02, 2, 15);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Giant Claw, The', 'Radiohumeral (joint) sprain of right elbow, init encntr', 34.99, 2, 8);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Sea Fog', 'Stenosis due to genitourinary prosth dev/grft, subs', 41.07, 5, 80);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('My Science Project', 'Driver injured in collision w unsp mv in traf, init', 29.07, 1, 52);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Cradle of Fear', 'Displ simp suprcndl fx w/o intrcndl fx r humer, 7thP', 39.12, 1, 11);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Death Race 3: Inferno', 'Stress fracture, right finger(s), init encntr for fracture', 49.35, 7, 71);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Dancing Lady', 'Chromosome replaced with ring, dicentric or isochromosome', 28.77, 3, 71);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Confessions of a Superhero', 'Injury of cutaneous sensory nerve at ank/ft level, unsp leg', 41.55, 8, 86);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('When Ladies Meet', 'Papyraceous fetus, third trimester, fetus 1', 33.16, 6, 16);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Death Watch (La Mort en Direct)', 'Other congenital malformations of eye', 31.7, 5, 80);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Abbott and Costello Go to Mars', 'Other dislocation of left foot, subsequent encounter', 11.82, 3, 53);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Roman Spring of Mrs. Stone, The', 'Displ artic fx head of r femr, 7thQ', 36.31, 7, 1);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Endeavour', 'Osteopathy in diseases classd elswhr, unsp ankle and foot', 11.45, 7, 88);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Auntie Mame', 'Other overlap syndromes', 21.15, 8, 12);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Call Me Crazy: A Five Film', 'Underdosing of amphetamines, sequela', 46.84, 9, 50);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Mrs. Parker and the Vicious Circle', 'Nodular prostate with lower urinary tract symptoms', 41.79, 7, 89);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Guilty (Présumé coupable)', 'Displaced transcondylar fracture of unsp humerus, sequela', 27.84, 5, 93);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Creeping Terror, The (Crawling Monster, The)', 'Paving stone degeneration of retina, left eye', 27.0, 6, 97);
insert into miTiendaSpringCastillejoJose.article (title, description, price, id_category, stock) values ('Dhobi Ghat', 'Partial traumatic amp of unsp forearm, level unsp, sequela', 33.71, 10, 14);
