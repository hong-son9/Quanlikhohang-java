drop DATABASE if  exists QLyKhoHang;
CREATE DATABASE QLyKhoHang
use QLyKhoHang

create TABLE Users
(
	id INT PRIMARY KEY,
	username VARCHAR(30), 
	password NVARCHAR(30),
	role INT,
	fullname nvarchar(30),
	address nvarchar(255),
	phone nvarchar(255)
);


create TABLE PhieuNhap(
	id INT PRIMARY KEY,
	dateIn DATETIME ,
	sumPayment FLOAT,
	userId INT NOT NULL,
	FOREIGN KEY (userId) REFERENCES Users(id)
)

create TABLE PhieuXuat(
	id INT PRIMARY KEY,
	dateOut DATETIME ,
	sumPayment FLOAT,
	userId INT NOT NULL,
	FOREIGN KEY (userId) REFERENCES Users(id)
)

create TABLE DanhMuc(
	id INT PRIMARY KEY,
	categpry_name nvarchar(255)
)

create TABLE SanPham (
	id INT PRIMARY KEY,
	name nvarchar(255),
	quantity_has  BIGINT,
	quantity_pay BIGINT,
	price float,
	categoty_id INT NOT NULL,
	FOREIGN KEY (categoty_id) REFERENCES DanhMuc(id)
)

create TABLE SP_Nhap(
	id INT PRIMARY KEY,
	quantity_in bigInt,
	price float,
	maSP INT NOT NULL,
	FOREIGN KEY (maSP) REFERENCES SanPham(id),
	maPhieuNhap INT NOT NULL,
	FOREIGN KEY (maPhieuNhap) REFERENCES PhieuNhap(id)
)

create TABLE SP_Xuat(
	id INT PRIMARY KEY,
	quantity_in bigInt,
	price float,
	maSP INT NOT NULL,
	FOREIGN KEY (maSP) REFERENCES SanPham(id),
	maPhieuXuat INT NOT NULL,
	FOREIGN KEY (maPhieuXuat) REFERENCES PhieuXuat(id)
)

INSERT INTO Users 
VALUES		(0, 'admin', 'admin',0,N'Nguyễn Khánh Thọ',N'Hoài Đức,Hà Nội', '0367238230'),	
			(1, 'user1', 'user1',1,N'Nguyễn Trọng Quân',N'Hoài Đức,Hà Nội', '0123456789')	;
select * from users;
INSERT INTO DanhMuc
VALUES 		(0,N'Tivi'),
			(1,N'Laptop'),
			(2,N'PC');
SELECT * FROM DanhMuc;
INSERT INTO SanPham
VALUES 		(0,N'TiVi Sony',10,0,5000000,0),
			(1,N'Laptop DELL',10,0,14000000,1),
			(2,N'PC ULTRA PRO',10,0,10000000,2);
INSERT INTO SanPham Values (3,N'ABC',10,0,10000000.5,2);     
INSERT INTO SanPham Values (4,N'ACB',10,0,100000.5,2);
SELECT * FROM SanPham;

INSERT INTO PhieuXuat
VALUES      (0,'2022-12-14',0,0),
			(1,'2023-1-31',0,1);

Update phieuxuat
set sumPayment = (SELECT SUM(price) FROM SP_Xuat WHERE maPhieuXuat = 0)
WHERE id = 0;