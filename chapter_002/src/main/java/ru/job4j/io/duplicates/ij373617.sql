CREATE TABLE IF NOT EXISTS products (
 productID    INTeger  NOT NULL,
 productCode  varCHAR(3)       NOT NULL DEFAULT '',
 name         VARCHAR(30)   NOT NULL DEFAULT '',
 quantity     INTeger  NOT NULL DEFAULT 0,
 price        DECIMAL(7,2)  NOT NULL DEFAULT 99999.99,
 supplierID INTeger
);
 INSERT INTO products (productID, productCode, name, quantity, price, supplierID) VALUES
  (1001, 'PEN', 'Pen Red', 5000, 1.23, 503),
  (1002,'PEC', 'Pencil 2B', 10000, 0.48, 501),
  (1003, 'PEN', 'Pen Blue',  8000, 1.25,501),
  (1004, 'PEN', 'Pen Black', 2000, 1.25, 502),
  (1005,'PEC', 'Pencil 2H', 8000, 0.49, 502);



 CREATE TABLE suppliers (
 supplierID  INTeger   NOT NULL , 
  name        VARCHAR(30)   NOT NULL DEFAULT '', 
  phone       varCHAR(8)       NOT NULL DEFAULT ''
 );

INSERT INTO suppliers VALUEs
(501, 'ABC Traders', '88881111'), 
(502, 'XYZ Company', '88882222'), 
(503, 'QQ Corp', '88883333');

 select s.name as "Трейдер" , p.productCode as "Код" , p.name as "Продукция"  
  from suppliers s ,  products p  
  where p.supplierID = s.supplierID;
          
 select s.name as Трейдер ,  p.name as Продукция, p.quantity as Количество
  from suppliers s ,  products p  
 where p.supplierID = s.supplierID;
          
 select  s.name as Traider ,  s.phone as Telephone  , p.name as Production, 
 p.price as Price, p.quantity as Quantity 
  from suppliers s ,  products p  
 where p.supplierID = s.supplierID;