CREATE TABLE [users] (
  [id] nvarchar(255) PRIMARY KEY,
  [username] nvarchar(255),
  [password] nvarchar(255),
  [fullname] nvarchar(255),
  [address] nvarchar(255)
)
GO

CREATE TABLE [roles] (
  [id] nvarchar(255) PRIMARY KEY,
  [name] nvarchar(255),
  [description] nvarchar(255)
)
GO

CREATE TABLE [user_role] (
  [userId] nvarchar(255),
  [roleId] nvarchar(255),
  PRIMARY KEY ([userId], [roleId])
)
GO

CREATE TABLE [categories] (
  [id] nvarchar(255) PRIMARY KEY,
  [name] nvarchar(255)
)
GO

CREATE TABLE [products] (
  [id] nvarchar(255) PRIMARY KEY,
  [name] nvarchar(255),
  [price] decimal,
  [amount] int,
  [image] nvarchar(255),
  [description] nvarchar(255),
  [original] nvarchar(255),
  [categoryId] nvarchar(255)
)
GO

CREATE TABLE [products_cats] (
  [productId] nvarchar(255) PRIMARY KEY,
  [sex] bit,
  [age] int,
  [color] nvarchar(255)
)
GO

CREATE TABLE [products_clothes] (
  [productId] nvarchar(255) PRIMARY KEY,
  [color] nvarchar(255),
  [size] nvarchar(255),
  [material] nvarchar(255)
)
GO

CREATE TABLE [products_food] (
  [productId] nvarchar(255) PRIMARY KEY,
  [dom] date,
  [exp] date,
  [weight] int
)
GO

CREATE TABLE [promotion] (
  [id] nvarchar(255) PRIMARY KEY,
  [promotion] int,
  [startDate] date,
  [endDate] date,
  [description] nvarchar(255)
)
GO

CREATE TABLE [products_promotion] (
  [promotionId] nvarchar(255),
  [productId] nvarchar(255),
  PRIMARY KEY ([promotionId], [productId])
)
GO

CREATE TABLE [orders] (
  [id] nvarchar(255) PRIMARY KEY,
  [userId] nvarchar(255),
  [ordersDate] date,
  [total] decimal,
  [status] nvarchar(255)
)
GO

CREATE TABLE [orders_detail] (
  [ordersId] nvarchar(255),
  [productId] nvarchar(255),
  [amount] int,
  [price] decimal,
  PRIMARY KEY ([ordersId], [productId])
)
GO

ALTER TABLE [user_role] ADD FOREIGN KEY ([userId]) REFERENCES [users] ([id])
GO

ALTER TABLE [user_role] ADD FOREIGN KEY ([roleId]) REFERENCES [roles] ([id])
GO

ALTER TABLE [products] ADD FOREIGN KEY ([categoryId]) REFERENCES [categories] ([id])
GO

ALTER TABLE [products_cats] ADD FOREIGN KEY ([productId]) REFERENCES [products] ([id])
GO

ALTER TABLE [products_clothes] ADD FOREIGN KEY ([productId]) REFERENCES [products] ([id])
GO

ALTER TABLE [products_food] ADD FOREIGN KEY ([productId]) REFERENCES [products] ([id])
GO

ALTER TABLE [products_promotion] ADD FOREIGN KEY ([promotionId]) REFERENCES [promotion] ([id])
GO

ALTER TABLE [products_promotion] ADD FOREIGN KEY ([productId]) REFERENCES [products] ([id])
GO

ALTER TABLE [orders] ADD FOREIGN KEY ([userId]) REFERENCES [users] ([id])
GO

ALTER TABLE [orders_detail] ADD FOREIGN KEY ([ordersId]) REFERENCES [orders] ([id])
GO

ALTER TABLE [orders_detail] ADD FOREIGN KEY ([productId]) REFERENCES [products] ([id])
GO

