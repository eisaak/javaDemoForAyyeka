-- -----------------------------------------------------
-- Schema ayyeka
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS ayyeka DEFAULT CHARACTER SET utf8 ;

USE ayyeka;



DROP TABLE IF EXISTS aggregated_measures;

CREATE TABLE IF NOT EXISTS aggregated_measures (
  agg_id INT(11) NOT NULL,
  device_id VARCHAR(45) NULL DEFAULT NULL,
  agg_type_id INT(11) NULL DEFAULT NULL,
  agg_year INT(4) NULL DEFAULT NULL,
  agg_month INT(2) NULL DEFAULT NULL,
  agg_day INT(2) NULL DEFAULT NULL,
  count_measures INT(11) NULL DEFAULT NULL,
  average FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (agg_id));

CREATE INDEX idx_agg_year
ON aggregated_measures(agg_year);

CREATE INDEX idx_agg_year
ON aggregated_measures(agg_month);

CREATE INDEX idx_agg_year
ON aggregated_measures(agg_day);
  
  
  
DROP TABLE IF EXISTS devices ;

CREATE TABLE IF NOT EXISTS devices (
  device_id INT(11) NOT NULL,
  device_type INT(11) NULL DEFAULT NULL,
  device_description TEXT NULL DEFAULT NULL,
  PRIMARY KEY (device_id));


  
  
DROP TABLE IF EXISTS dictionary_aggregation_types ;

CREATE TABLE IF NOT EXISTS dictionary_aggregation_types (
  agg_type_id INT(11) NOT NULL,
  agg_type_name VARCHAR(45) NULL DEFAULT NULL,
  remark TEXT NULL DEFAULT NULL,
  PRIMARY KEY (agg_type_id));


  
  
DROP TABLE IF EXISTS dictionary_device_types ;

CREATE TABLE IF NOT EXISTS dictionary_device_types (
  device_type_id INT(11) NOT NULL,
  device_type VARCHAR(50) NULL DEFAULT NULL,
  description TEXT NULL DEFAULT NULL,
  PRIMARY KEY (device_type_id));


  
  
DROP TABLE IF EXISTS raw_measures ;

CREATE TABLE IF NOT EXISTS raw_measures (
  measure_id INT(11) NOT NULL AUTO_INCREMENT,
  measured_time DATE NOT NULL,
  measured_value FLOAT NOT NULL,
  device_id INT(11) NOT NULL,
  PRIMARY KEY (measure_id));

