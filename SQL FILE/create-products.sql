-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS ecommerce;

CREATE SCHEMA ecommerce;
USE ecommerce;

-- -----------------------------------------------------
-- Table `ecommerce`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ecommerce.product_category (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  category_name VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (id))
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `ecommerce`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ecommerce.product (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  sku VARCHAR(255) DEFAULT NULL,
  name VARCHAR(255) DEFAULT NULL,
  description VARCHAR(255) DEFAULT NULL,
  unit_price DECIMAL(13,2) DEFAULT NULL,
  image_url VARCHAR(255) DEFAULT NULL,
  active BIT DEFAULT 1,
  units_in_stock INT(11) DEFAULT NULL,
  date_created DATETIME(6) DEFAULT NULL,
  last_updated DATETIME(6) DEFAULT NULL,
  category_id BIGINT(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id) REFERENCES product_category(id)
) 
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------
INSERT INTO product_category(category_name) VALUES ('BOOKS');

INSERT INTO product (sku, name, description, unit_price, image_url, active, units_in_stock, date_created, last_updated, category_id)
VALUES 
('BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript', 19.99, 'assets/images/products/placeholder.png', 1, 100, NOW(), NOW(), 1),
('BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring', 29.99, 'assets/images/products/placeholder.png', 1, 100, NOW(), NOW(), 1),
('BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes', 29.99, 'assets/images/products/placeholder.png', 1, 100, NOW(), NOW(), 1),
('BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT', 29.99, 'assets/images/products/placeholder.png', 1, 100, NOW(), NOW(), 1),
('BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go', 24.99, 'assets/images/products/placeholder.png', 1, 100, NOW(), NOW(), 1);