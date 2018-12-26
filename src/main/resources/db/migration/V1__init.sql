CREATE TABLE IF NOT EXISTS `cargos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `id_departamento_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gseglqgqp16hn9j3pqn06m8oy` (`nome`),
  KEY `FKtjl420ddyfp607dq6vo67blqi` (`id_departamento_fk`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `departamentos`
--

CREATE TABLE IF NOT EXISTS `departamentos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gmqvdqbwy3c9wja72wnfd01kc` (`nome`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `enderecos`
--

CREATE TABLE IF NOT EXISTS `enderecos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) NOT NULL,
  `numero` varchar(5) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `funcionario_id` bigint(20) DEFAULT NULL,
  `id_funcionario_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg3yue99x2n30pjix0rvk6g6hr` (`funcionario_id`),
  KEY `FK8e5bux1cu5l7xpf3m5ct5m7e5` (`id_funcionario_fk`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `funcionarios`
--

CREATE TABLE IF NOT EXISTS `funcionarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_entrada` date NOT NULL,
  `data_saida` date DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `salario` decimal(9,2) NOT NULL DEFAULT '0.00',
  `id_cargo_fk` bigint(20) DEFAULT NULL,
  `id_endereco_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtkkwtttadypkvw6dpjo4rjoya` (`id_cargo_fk`),
  KEY `FKk2f72ysx86m8tpilerp0lxyed` (`id_endereco_fk`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
