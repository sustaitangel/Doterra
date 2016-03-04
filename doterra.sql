/*
Navicat MySQL Data Transfer

Source Server         : terra
Source Server Version : 50710
Source Host           : 127.0.0.1:3306
Source Database       : doterra

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-03-03 21:43:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for categoria
-- ----------------------------
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categoria
-- ----------------------------
INSERT INTO `categoria` VALUES ('1', 'aceites essenciales');
INSERT INTO `categoria` VALUES ('2', 'mezclas de aceites ');
INSERT INTO `categoria` VALUES ('3', 'kits de inscripcion');
INSERT INTO `categoria` VALUES ('4', 'accesorios');
INSERT INTO `categoria` VALUES ('5', 'cuidado personal');

-- ----------------------------
-- Table structure for clientes
-- ----------------------------
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `id_cliente` bigint(30) NOT NULL AUTO_INCREMENT,
  `id` bigint(30) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `a_paterno` varchar(25) DEFAULT NULL,
  `a_materno` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `telefono` bigint(30) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clientes
-- ----------------------------
INSERT INTO `clientes` VALUES ('1', '54321', 'pancho', 'barraza', 'moo', 'jfjfhfvhf', '9331780');

-- ----------------------------
-- Table structure for perfil
-- ----------------------------
DROP TABLE IF EXISTS `perfil`;
CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(15) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of perfil
-- ----------------------------
INSERT INTO `perfil` VALUES ('1', 'Administrador');
INSERT INTO `perfil` VALUES ('2', 'Empleado');

-- ----------------------------
-- Table structure for productos
-- ----------------------------
DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `id_producto` bigint(30) NOT NULL AUTO_INCREMENT,
  `clave` bigint(30) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `nombre_espanol` varchar(25) DEFAULT NULL,
  `unidad` varchar(11) DEFAULT NULL,
  `precio_cliente` float NOT NULL,
  `precio_distribuidor` float NOT NULL,
  `precio_gota` float NOT NULL,
  `pv` float NOT NULL,
  `categoria_id_categoria` int(11) NOT NULL,
  `cantidad` int(32) DEFAULT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=MyISAM AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productos
-- ----------------------------
INSERT INTO `productos` VALUES ('16', '30010608', 'Basil', 'Albahaca', '15 ml', '420', '310', '1.8', '20', '1', '3');
INSERT INTO `productos` VALUES ('29', '30070608', 'FRANKINCENSE', 'INCIENSO', '15 ML', '1420', '1060', '5', '69.75', '1', '3');
INSERT INTO `productos` VALUES ('18', '30790608', 'BERGAMOTA', 'BERGAMOTA', '15 ML', '560', '420', '2.5', '27.5', '1', '2');
INSERT INTO `productos` VALUES ('19', '41040608', 'BLACK PEPPER', 'PIMIENTA NEGRA', '15 ML', '460', '340', '6', '22', '1', '4');
INSERT INTO `productos` VALUES ('20', '30020608', 'CASSIA', 'CASSIA', '15 ML', '435', '326', '2', '19', '1', '4');
INSERT INTO `productos` VALUES ('21', '49300508', 'CEDARWOOD', 'CEDRO', '15 ML', '354', '265', '1.5', '14.5', '1', '4');
INSERT INTO `productos` VALUES ('22', '41850608', 'CILANTRO', 'CILANTRO', '15 ML', '540', '400', '2.5', '26', '1', '4');
INSERT INTO `productos` VALUES ('23', '30030608', 'CINNAMON', 'CANELA', '5 ML', '430', '320', '5.5', '21', '1', '4');
INSERT INTO `productos` VALUES ('24', '30420608', 'CLARY SAGE', 'SALVIA', '15 ML', '750', '560', '3.1', '36.5', '1', '10');
INSERT INTO `productos` VALUES ('25', '30040608', 'CLOVE', 'CLAVO', '15 ML', '300', '220', '1.5', '14', '1', '20');
INSERT INTO `productos` VALUES ('26', '30780608', 'CORIANDER', 'S. CILANTRO', '15 ML', '540', '400', '2.5', '26', '1', '20');
INSERT INTO `productos` VALUES ('27', '30050508', 'CYPRESS', 'CIPRES', '15 ML', '320', '240', '1.3', '15', '1', '10');
INSERT INTO `productos` VALUES ('28', '30060508', 'EUCALYPTUS', 'EUCALIPTO', '15 ML', '300', '220', '1.5', '14', '1', '20');
INSERT INTO `productos` VALUES ('30', '30090608', 'GERANIUM', 'GERANIO', '15 ML', '550', '410', '2.3', '27', '1', '30');
INSERT INTO `productos` VALUES ('31', '30100608', 'GRAPEFRUIT', 'TORONJA (POMELO)', '15 ML', '340', '250', '1.5', '16', '1', '30');
INSERT INTO `productos` VALUES ('32', '30080608', 'GINGER', 'JENGIBRE', '15 ML', '663', '497', '8.2', '29', '1', '20');
INSERT INTO `productos` VALUES ('33', '30410608', 'HELICHRYSUM', 'HELICRISO', '5 ML', '1520', '1140', '19', '75', '1', '10');
INSERT INTO `productos` VALUES ('34', '30110608', 'LAVENDER', 'LAVANDA', '15 ML', '430', '320', '2', '21', '1', '20');
INSERT INTO `productos` VALUES ('35', '30120608', 'LEMON', 'LIMON', '15 ML', '220', '160', '1', '10', '1', '40');
INSERT INTO `productos` VALUES ('36', '30130608', 'LEMONGRASS', 'LIMONCILLO', '15 ML', '220', '160', '1', '10', '1', '60');
INSERT INTO `productos` VALUES ('37', '30870608', 'LIME', 'LIMA', '15 ML', '270', '200', '1.2', '13', '1', '30');
INSERT INTO `productos` VALUES ('38', '30140608', 'MARJORAM', 'MEJORANA', '15 ML', '390', '290', '1.7', '19', '1', '20');
INSERT INTO `productos` VALUES ('39', '30150608', 'MELALEUCA', 'MELALEUCA', '15 ML', '390', '290', '1.7', '19', '1', '30');
INSERT INTO `productos` VALUES ('40', '30160608', 'MYRRH', 'MYRRA', '15 ML', '1060', '790', '4.5', '52', '1', '10');
INSERT INTO `productos` VALUES ('41', '30180608', 'OREGANO', 'OREGANO', '15 ML', '500', '370', '2.2', '24', '1', '50');
INSERT INTO `productos` VALUES ('42', '30890608', 'PATCHOULI', 'PACHULI', '15 ML', '600', '450', '2.6', '29.5', '1', '10');
INSERT INTO `productos` VALUES ('43', '30190608', 'PEPPERMINT', 'MENTA', '15 ML', '420', '310', '1.9', '20.5', '1', '30');
INSERT INTO `productos` VALUES ('44', '30800608', 'ROMAN CHAMOMILE', 'MANZANILLA ROMANA', '5 ML', '670', '500', '8.5', '33', '1', '10');
INSERT INTO `productos` VALUES ('45', '30200608', 'ROSEMARY', 'ROMERO', '15 ML', '300', '220', '1.3', '14', '1', '30');
INSERT INTO `productos` VALUES ('46', '41290608', 'SWEET FENNEL', 'HINOJO', '15 ML', '310', '230', '1.5', '15', '1', '10');
INSERT INTO `productos` VALUES ('47', '30220608', 'THYME', 'TOMILLO', '15 ML', '560', '420', '2.4', '27.5', '1', '20');
INSERT INTO `productos` VALUES ('48', '30430608', 'VETIVER', 'VETIVER', '15 ML', '710', '530', '3.1', '34', '1', '10');
INSERT INTO `productos` VALUES ('49', '30250508', 'WHITE FIR', 'ABETO BLANCO', '15 ML', '420', '310', '2', '20', '1', '10');
INSERT INTO `productos` VALUES ('50', '30170608', 'WILD ORANGE', 'NARANJA SILVESTRE', '15 ML', '220', '160', '1', '10.5', '1', '110');
INSERT INTO `productos` VALUES ('51', '30230508', 'WINTERGREEN', 'GAULTERIA', '15 ML', '340', '250', '1.5', '16', '1', '10');
INSERT INTO `productos` VALUES ('52', '30240608', 'YLANG YLANG', 'YLANG YLANG', '15 ML', '720', '540', '3.2', '35.25', '1', '110');
INSERT INTO `productos` VALUES ('53', '49290508', 'JUNIPER BERRY', 'BAYAS DE ENEBRO', '5 ML', '527', '395', '2.4', '75', '1', '10');
INSERT INTO `productos` VALUES ('54', '31570001', 'PEPPERMINT BEADLET', 'PERLAS DE MENTA', '125 PZA', '320', '240', '2.56', '13', '1', '10');
INSERT INTO `productos` VALUES ('55', '49360001', 'ARBOVITAE', 'TUYA', '5 ML', '635', '476', '7.5', '22', '1', '10');
INSERT INTO `productos` VALUES ('56', '49350001', 'CARDAMOM', 'CARDAMOMO', '5 ML', '750', '562', '10', '26', '1', '110');
INSERT INTO `productos` VALUES ('57', '30210001', 'SANDALWOOD', 'SANDALO', '5 ML', '1780', '1335', '30', '61.8', '1', '10');
INSERT INTO `productos` VALUES ('58', '31200508', 'AROMA TOUCH', 'MEZCLA MASAJISTA', '15 ML', '540', '400', '2.5', '26', '2', '12');
INSERT INTO `productos` VALUES ('59', '31010508', 'BALANCE', 'MEZCLA TRANQUILIDAD', '15 ML', '420', '310', '2', '20', '2', '10');
INSERT INTO `productos` VALUES ('60', '31020508', 'CITRUS BLISS', 'MEZCLA VIGORIZANTE', '15 ML', '310', '230', '1.5', '15', '2', '10');
INSERT INTO `productos` VALUES ('61', '35270508', 'CLARY CALM ROLL ON', 'MEZCLA PARA MUJER', '10 ML', '510', '380', '3.5', '24.5', '2', '10');
INSERT INTO `productos` VALUES ('62', '31050508', 'DEEP BLUE ', 'MEZCLA CALMANTE', '5 ML', '660', '450', '10', '29.5', '2', '210');
INSERT INTO `productos` VALUES ('63', '31380508', 'DEEP BLUE ROLL ON', 'MEZCLA CALMANTE ROLL ON', '10 ML', '1300', '970', '20', '64', '2', '10');
INSERT INTO `productos` VALUES ('64', '38900508', 'DEEP BLUE RUB', 'MEZ. CREMA CALMANTE', '4 OZ', '600', '450', '0.1', '29.25', '2', '10');
INSERT INTO `productos` VALUES ('65', '34360001', 'DEEP BLUE CAPS', 'MEZ. CALMANTE CAPSULAS', '60 PZA', '1507', '1130', '0.01', '59.5', '2', '10');
INSERT INTO `productos` VALUES ('66', '31030608', 'DIGESTZEN', 'MEZCLA DIGESTIVA', '15 ML', '630', '470', '2.8', '31', '2', '410');
INSERT INTO `productos` VALUES ('67', '35430001', 'DIGESTZEN SOFT GELS', 'DIGESTZEN CAPSULAS', '60 CAPS', '647', '487', '11', '15', '2', '10');
INSERT INTO `productos` VALUES ('68', '34380001', 'DIGESTZEN TAB', 'MEZCLA DIGESTIVA TABLETAS', '100 TAB', '404', '303', '4.04', '10', '2', '10');
INSERT INTO `productos` VALUES ('69', '49370508', 'BREATHE', 'EASY AIR MEZC. RESP', '15 ML', '420', '310', '2', '20', '2', '10');
INSERT INTO `productos` VALUES ('70', '31040508', 'ELEVATION', 'MEZCLA ALEGRIA', '15 ML', '750', '560', '3.2', '37', '2', '10');
INSERT INTO `productos` VALUES ('71', '418400001', 'IN TUNE / ON TASK', 'MEZCLA CONCENTRACION', '10 ML', '710', '530', '4.6', '34.5', '2', '10');
INSERT INTO `productos` VALUES ('72', '31100608', 'ON GUARD', 'MEZCLA PROTECTORA', '15 ML', '660', '490', '3', '32', '2', '10');
INSERT INTO `productos` VALUES ('73', '31350508', 'PAST TENSE ROLL ON', 'MEZCLA CONTRA TENSION', '10 ML', '380', '280', '2.6', '18.5', '2', '10');
INSERT INTO `productos` VALUES ('74', '31060508', 'PURIFY', 'MEZCLA PURIFICADORA', '15 ML', '380', '280', '1.8', '18', '2', '10');
INSERT INTO `productos` VALUES ('75', '37140508', 'SALUBELLE ROLL ON', 'MEZCLA ANTIENVEJECIMIETO', '10 ML', '1420', '1060', '10', '69.5', '2', '10');
INSERT INTO `productos` VALUES ('76', '31090508', 'SERENITY', 'MEZCLA PARA LA CALMA', '15 ML', '620', '460', '2.8', '30', '2', '10');
INSERT INTO `productos` VALUES ('77', '31370608', 'SMART AND SASSY', 'MEZCLA METABOLICA', '15 ML', '510', '380', '2.3', '24.5', '2', '20');
INSERT INTO `productos` VALUES ('78', '31080508', 'WHISPER', 'MEZCLA PARA LA MUJER', '5 ML', '500', '370', '7.5', '24', '2', '10');
INSERT INTO `productos` VALUES ('79', '31460608', 'ZENDOCRINE', 'MEZCLA DESINTOXICACION', '15 ML', '560', '420', '2.5', '24.5', '2', '10');
INSERT INTO `productos` VALUES ('80', '230', 'jabon', 'jabon', '12ml', '12', '12', '12', '25', '3', '10');
INSERT INTO `productos` VALUES ('81', '1234', 'alfa', 'beta', '15 ml', '250', '200', '15', '20', '3', '10');

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(13) NOT NULL,
  `apellido_paterno` varchar(13) NOT NULL,
  `apellido_materno` varchar(13) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `perfil_id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`perfil_id_perfil`),
  KEY `fk_usuarios_perfil_idx` (`perfil_id_perfil`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES ('7', 'RAIUL', 'MARTINEZ', 'ROMAN', '32e73311b58b07353cbc948f454f9ca5', 'RMTZ', '1');
INSERT INTO `usuarios` VALUES ('9', 'Empleado', 'emp', 'emp', '827ccb0eea8a706c4c34a16891f84e7b', 'Empleado', '2');
INSERT INTO `usuarios` VALUES ('3', 'Jairo', 'Jara', 'Castro', '7488e331b8b64e5794da3fa4eb10ad5d', 'admin', '1');
INSERT INTO `usuarios` VALUES ('10', 'juan', 'perez', 'alvarado', '25d55ad283aa400af464c76d713c07ad', 'juan', '1');
INSERT INTO `usuarios` VALUES ('11', 'petra', 'del hoyo', 'u', '25f9e794323b453885f5181f1b624d0b', 'petraa', '2');

-- ----------------------------
-- Table structure for ventas
-- ----------------------------
DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `folio` varchar(10) NOT NULL,
  `cliente` varchar(15) NOT NULL,
  `importe` float NOT NULL,
  `total_pv` float NOT NULL,
  `fecha` date NOT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`id_venta`)
) ENGINE=MyISAM AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ventas
-- ----------------------------
INSERT INTO `ventas` VALUES ('1', 'DT0001', '', '420', '20', '2016-02-23', '420');
INSERT INTO `ventas` VALUES ('2', 'DT0007', '', '800', '40', '2016-02-23', '840');
INSERT INTO `ventas` VALUES ('3', 'DT0008', '', '420', '20', '2016-02-23', '420');
INSERT INTO `ventas` VALUES ('4', 'DT0009', '', '840', '40', '2016-02-23', '840');
INSERT INTO `ventas` VALUES ('5', 'DT00010', '54321', '500', '40', '2016-02-29', '500');
INSERT INTO `ventas` VALUES ('6', 'DT00011', '', '2000', '160', '2016-02-29', '2000');

-- ----------------------------
-- Table structure for ventas_has_productos
-- ----------------------------
DROP TABLE IF EXISTS `ventas_has_productos`;
CREATE TABLE `ventas_has_productos` (
  `clave` bigint(30) NOT NULL,
  `folio` varchar(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `nombre` varchar(32) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `total_pv` float(12,0) DEFAULT NULL,
  `cantidad` int(32) DEFAULT NULL,
  `cliente` varchar(32) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ventas_has_productos
-- ----------------------------
INSERT INTO `ventas_has_productos` VALUES ('30010608', 'DT0001', '2016-02-23', 'Basil', '420', '20', '1', '', '9');
INSERT INTO `ventas_has_productos` VALUES ('30010608', 'DT0007', '2016-02-23', 'Basil', '420', '20', '1', '', '10');
INSERT INTO `ventas_has_productos` VALUES ('30010608', 'DT0007', '2016-02-23', 'Basil', '420', '20', '1', '', '11');
INSERT INTO `ventas_has_productos` VALUES ('30010608', 'DT0008', '2016-02-23', 'Basil', '420', '20', '1', '', '12');
INSERT INTO `ventas_has_productos` VALUES ('30010608', 'DT0009', '2016-02-23', 'Basil', '420', '20', '1', '', '13');
INSERT INTO `ventas_has_productos` VALUES ('30010608', 'DT0009', '2016-02-23', 'Basil', '420', '20', '1', '', '14');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00010', '2016-02-29', 'alfa', '250', '20', '1', '54321', '15');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00010', '2016-02-29', 'alfa', '250', '20', '1', '54321', '16');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00011', '2016-02-29', 'alfa', '250', '20', '1', '', '17');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00011', '2016-02-29', 'alfa', '250', '20', '1', '', '18');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00011', '2016-02-29', 'alfa', '250', '20', '1', '', '19');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00011', '2016-02-29', 'alfa', '250', '20', '1', '', '20');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00011', '2016-02-29', 'alfa', '250', '20', '1', '', '21');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00011', '2016-02-29', 'alfa', '250', '20', '1', '', '22');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00011', '2016-02-29', 'alfa', '250', '20', '1', '', '23');
INSERT INTO `ventas_has_productos` VALUES ('1234', 'DT00011', '2016-02-29', 'alfa', '250', '20', '1', '', '24');
