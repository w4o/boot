-- product
INSERT INTO `product`(`id`, `code`, `name`, `price`, `deleted`) VALUES (1, 'A0001', '海参炒面', 20.00, 0);
INSERT INTO `product`(`id`, `code`, `name`, `price`, `deleted`) VALUES (2, 'A0002', '大宝剑', 456.78, 0);

-- department
insert into `department`(`id`, `name`) VALUES (1, '财务部');
insert into `department`(`id`, `name`) VALUES (2, '开发部');

-- employee
insert into `employee`(`id`, `dept_id`, `name`, `contact`, `deleted`, `in_the_date`) values (1, 1, '张三', '13811111111', 0, '2019-12-12 08:08:08');
insert into `employee`(`id`, `dept_id`, `name`, `contact`, `deleted`, `in_the_date`) values (2, 2, '李四', '13900000000', 0, '2019-12-13 08:08:08');
insert into `employee`(`id`, `dept_id`, `name`, `contact`, `deleted`, `in_the_date`) values (3, 2, '王五', '13622222222', 0, '2019-12-14 08:08:08');