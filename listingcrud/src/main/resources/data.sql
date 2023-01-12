insert into Listing (id, title, address, type, locationId, image, price, guests, cap, rating, userId, isTrending) values
(1,'Home','123 xyz road', 'Hotel', 1001, 'https://images.unsplash.com/photo-1600585154340-be6161a56a0c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8aG9tZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60', 100, 0 , 5, 5.00, 1001, true),
(2,'Home','123 xyz road', 'Hotel', 1001, 'https://images.unsplash.com/photo-1512917774080-9991f1c4c750?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8aG9tZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60', 100, 0, 5, 5.00, 1001, false),
(3,'Home','123 xyz road', 'Cottage', 1002, 'https://images.unsplash.com/photo-1628624747186-a941c476b7ef?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8aG9tZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60', 100, 0, 5, 4.53, 1000, true),
(4,'Home','123 xyz road', 'Cottage', 1003,'https://images.unsplash.com/photo-1570129477492-45c003edd2be?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8aG91c2V8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60' , 100,0, 5, 4.70, 1000, false),
(5,'Home','123 xyz road', 'Igloo',1004,'https://images.unsplash.com/photo-1568605114967-8130f3a36994?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8aG91c2V8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60' ,100, 0 , 5,5.00, 1001, false ),
(6,'Home','123 xyz road','Condo', 1005, 'https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8aG91c2V8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60', 100, 0, 5, 4.91, 1000, true),
(7,'Home','123 xyz road','House', 1006, 'https://images.unsplash.com/photo-1564013799919-ab600027ffc6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fGhvdXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60', 100, 0, 5, 5.00, 1000, true);



insert into Favourites (id, userId, listingId) values
(1,1000, 2),
(2, 1001, 4);