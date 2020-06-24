INSERT INTO productos(pk_producto, nombre, cantidad_disponible)values(1,'Carne', 1000);
INSERT INTO productos(pk_producto, nombre, cantidad_disponible)values(2,'Pan de Hamburguesa', 1000);
INSERT INTO productos(pk_producto, nombre, cantidad_disponible)values(3,'Nuggets', 1000);
INSERT INTO productos(pk_producto, nombre, cantidad_disponible)values(4,'Alitas', 1000);
INSERT INTO productos(pk_producto, nombre, cantidad_disponible)values(5,'Pollo', 1000);
INSERT INTO productos(pk_producto, nombre, cantidad_disponible)values(6,'Quese Americano', 1000);
INSERT INTO productos(pk_producto, nombre, cantidad_disponible)values(7,'Queso Suizo', 1000);
INSERT INTO productos(pk_producto, nombre, cantidad_disponible)values(8,'Filete de pollo', 1000);


INSERT INTO inventarios(pk_inventario, cantidad, fk_producto)values(1,1000, 1);
INSERT INTO inventarios(pk_inventario, cantidad, fk_producto)values(2,1000, 2);
INSERT INTO inventarios(pk_inventario, cantidad, fk_producto)values(3,1000, 3);
INSERT INTO inventarios(pk_inventario, cantidad, fk_producto)values(4,1000, 4);
INSERT INTO inventarios(pk_inventario, cantidad, fk_producto)values(5,1000, 5);
INSERT INTO inventarios(pk_inventario, cantidad, fk_producto)values(6,1000, 6);
INSERT INTO inventarios(pk_inventario, cantidad, fk_producto)values(7,1000, 7);
INSERT INTO inventarios(pk_inventario, cantidad, fk_producto)values(8,1000, 8);


INSERT INTO menus(pk_menu, nombre)values(1,'Hamburgesa Simple');
INSERT INTO menus(pk_menu, nombre)values(2,'Hamburgesa Doble');
INSERT INTO menus(pk_menu, nombre)values(3,'Hamburgesa Triple');
INSERT INTO menus(pk_menu, nombre)values(4,'Alitas BBQ');
INSERT INTO menus(pk_menu, nombre)values(5,'Pollo Familiar');

INSERT INTO usuarios(pk_usuario,nombre,apellido,contrato,rol,email)values(1,'Juan','Velasco','Tiempo Completo','Administrador','jcvelasco@espe.edu.ec');
INSERT INTO usuarios(pk_usuario,nombre,apellido,contrato,rol,email)values(2,'Dair','Sanchez','Medio Tiempo','Lider Conteo','fdsanchez@espe.edu.ec');


