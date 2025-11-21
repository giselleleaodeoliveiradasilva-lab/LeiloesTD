Sistema de Gestão e Leilões de Produtos (LeilõesTD)

Este projeto implementa um sistema simples de cadastro, listagem e controle de status de venda (leilões) de produtos. Foi desenvolvido em **Java** utilizando a interface gráfica **Swing** e o padrão de persistência de dados **DAO (Data Access Object)** para comunicação com o banco de dados.

## 🚀 Funcionalidades da Aplicação

O sistema oferece as seguintes operações através das interfaces gráficas:

* **Cadastro (`cadastroVIEW`):** Permite inserir novos produtos com **Nome** e **Valor**. O `Status` inicial é definido automaticamente como **`A Venda`**.
* **Listagem (`listagemVIEW`):** Exibe todos os produtos cadastrados e permite a operação de venda (mudança de status).
* **Venda:** Permite alterar o status de um produto (via ID) de **`A Venda`** para **`Vendido`**.
* **Consulta de Vendas (`vendasVIEW`):** Exibe uma lista separada apenas dos produtos que possuem o status **`Vendido`**.

---

## ⚙️ Pré-requisitos e Tecnologias

Para executar este projeto localmente, você precisa do seguinte ambiente configurado:

1.  **Java Development Kit (JDK):** Versão 8 ou superior.
2.  **IDE:** NetBeans (Provavelmente utilizado para gerar as *VIEWs* e estrutura).
3.  **Banco de Dados:** Servidor **MySQL** ou **MariaDB** (via XAMPP/WAMP/MAMP).
4.  **Conector JDBC:** O arquivo `.jar` do conector MySQL JDBC deve ser adicionado às bibliotecas do projeto para permitir a comunicação.

---

## 💾 Configuração do Banco de Dados (`uc11`)

O projeto utiliza o banco de dados **`uc11`** e a tabela **`produtos`**.

### 1. Script SQL para Criação e Estrutura

Para configurar o banco de dados, execute o seguinte script no seu gerenciador de banco de dados (ex: phpMyAdmin ou MySQL Workbench):

```sql
-- Nome do Banco de Dados: uc11
CREATE DATABASE uc11;

-- Estrutura da Tabela `produtos`
CREATE TABLE `produtos` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` text DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `status` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exemplo de Dados Iniciais (Opcional)
INSERT INTO `produtos` (`nome`, `valor`, `status`) VALUES
('PS4', 1500, 'Vendido'),
('Xbox 360', 800, 'Vendido'),
('Iphone 12', 4800, 'Vendido'),
('PS2', 400, 'A Venda');