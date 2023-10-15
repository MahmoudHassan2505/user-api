INSERT INTO public.role(name)
VALUES ('Admin'),('Coupon Manger'),('Product Manger'),('Stock Manger');

INSERT INTO public.users(username, password, is_active, role_id)
VALUES ('admin','admin',true,1);