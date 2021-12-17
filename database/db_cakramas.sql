-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 19, 2021 at 08:30 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_cakramas`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id` char(25) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `kode` char(25) DEFAULT NULL,
  `harganet` double DEFAULT NULL,
  `hargajual` double DEFAULT NULL,
  `stok` smallint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `nama`, `kode`, `harganet`, `hargajual`, `stok`) VALUES
('BRG01', 'Asus E203MAH-FD411T', 'KJB02', 3300000, 3970000, 20),
('BRG02', 'Lenovo Ideapad Flex 3 11', 'KJB02', 4250000, 5150000, 32),
('BRG03', 'Asus E203MAH-FD413T', 'KJB02', 4300000, 5300000, 4),
('BRG04', 'DELL Inspiron 11-3169M3 W10', 'KJB02', 5450000, 6900000, 31),
('BRG05', 'HP-14s-CF2004TX Notebook', 'KJB05', 7300000, 9500000, 23),
('BRG06', 'HP PAV 14-DV0066TX Silver', 'KJB05', 9250000, 12000000, 17),
('BRG07', 'DELL Inspiron 5570 Core I7', 'KJB06', 1100000, 13650000, 9);

-- --------------------------------------------------------

--
-- Table structure for table `detail_pembelian`
--

CREATE TABLE IF NOT EXISTS `detail_pembelian` (
  `id` char(25) DEFAULT NULL,
  `kodebarang` char(24) NOT NULL,
  `jumlah` smallint(4) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_pembelian`
--

INSERT INTO `detail_pembelian` (`id`, `kodebarang`, `jumlah`, `subtotal`) VALUES
('PB01', 'BRG01', 2, 46000),
('PB01', 'BRG02', 3, 240000),
('PB02', 'BRG01', 1, 23000),
('PB02', 'BRG01', 1, 23000),
('PB02', 'BRG01', 2, 46000),
('PB02', 'BRG01', 4, 3970000),
('PB02', 'BRG05', 1, 9500000),
('PB02', 'BRG04', 1, 6900000),
('PB02', 'BRG02', 1, 5150000),
('PB02', 'BRG05', 1, 9500000),
('PB02', 'BRG05', 1, 9500000),
('PB02', 'BRG04', 1, 6900000),
('PB02', 'BRG01', 1, 3970000),
('PB02', 'BRG04', 1, 6900000),
('PB03', 'BRG05', 1, 9500000),
('PB04', 'BRG04', 1, 6900000);

-- --------------------------------------------------------

--
-- Table structure for table `detail_penjualan`
--

CREATE TABLE IF NOT EXISTS `detail_penjualan` (
  `id` char(10) NOT NULL,
  `kodebarang` char(26) NOT NULL,
  `jumlah` smallint(26) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_penjualan`
--

INSERT INTO `detail_penjualan` (`id`, `kodebarang`, `jumlah`, `subtotal`) VALUES
('PJ01', 'BRG01', 12, 276000),
('PJ01', 'BRG02', 2, 160000),
('PJ02', 'BRG04', 1, 6900000),
('PJ02', 'BRG04', 1, 6900000);

-- --------------------------------------------------------

--
-- Table structure for table `detail_retur`
--

CREATE TABLE IF NOT EXISTS `detail_retur` (
  `id` char(25) DEFAULT NULL,
  `kodebarang` char(24) NOT NULL,
  `jumlah` smallint(4) DEFAULT NULL,
  `keterangan` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_retur`
--

INSERT INTO `detail_retur` (`id`, `kodebarang`, `jumlah`, `keterangan`) VALUES
('RET01', 'BRG01', 2, 'Cacat'),
('RET01', 'BRG02', 1, 'Kelebihan Pesan'),
('RET02', 'BRG04', 1, 'Rusak'),
('RET02', 'BRG02', 2, 'Rusak'),
('RET02', 'BRG06', 1, 'Ada Penyok');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE IF NOT EXISTS `pembelian` (
  `id` char(10) NOT NULL,
  `tglbeli` varchar(30) DEFAULT NULL,
  `idsup` char(25) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`id`, `tglbeli`, `idsup`, `total`) VALUES
('PB01', '2020-07-20', 'SUP01', 286000),
('PB02', '2021-02-19', 'SUP03', 6900000),
('PB03', '2021-02-19', 'SUP06', 9500000),
('PB04', '2021-02-19', 'SUP02', 6900000);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE IF NOT EXISTS `penjualan` (
  `id` char(20) NOT NULL,
  `tglpenjualan` varchar(30) DEFAULT NULL,
  `bayar` double DEFAULT NULL,
  `sisa` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id`, `tglpenjualan`, `bayar`, `sisa`, `total`) VALUES
('PJ01', '2020-07-21', 440000, 4000, 436000),
('PJ02', '2021-02-18', 7000000, 100000, 6900000);

-- --------------------------------------------------------

--
-- Table structure for table `retur`
--

CREATE TABLE IF NOT EXISTS `retur` (
  `id` char(10) NOT NULL,
  `tglretur` varchar(30) DEFAULT NULL,
  `idsup` char(25) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `retur`
--

INSERT INTO `retur` (`id`, `tglretur`, `idsup`, `total`) VALUES
('RET01', '2020-07-21', 'SUP01', 3),
('RET02', '2021-02-16', 'SUP05', 4);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `id` varchar(30) NOT NULL,
  `nama` varchar(28) NOT NULL,
  `telp` varchar(18) NOT NULL,
  `alamat` tinytext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `nama`, `telp`, `alamat`) VALUES
('SUP01', 'Global Telecomindo', '021 62317931', 'Jakarta Utara'),
('SUP02', 'Dstore Computer', '021 60036677', 'Gedung Harco Jakarta'),
('SUP03', 'DELL Store Jakarta', '0818822655', 'Jakarta Utara'),
('SUP04', 'Re Computer', '082177123623', 'Jakarta Pusat'),
('SUP05', 'PT Robicomp Komputindo Utama', '021 6330333', 'Jakarta Pusat'),
('SUP06', 'CV Havid Computer', '087780149485', 'Jakarta Timur');

-- --------------------------------------------------------

--
-- Table structure for table `tbljenis`
--

CREATE TABLE IF NOT EXISTS `tbljenis` (
  `kodejenis` char(25) NOT NULL,
  `jenis` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`kodejenis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbljenis`
--

INSERT INTO `tbljenis` (`kodejenis`, `jenis`) VALUES
('KJB01', 'Personal Komputer'),
('KJB02', 'Laptop 11 inch'),
('KJB03', 'Laptop 12 inch'),
('KJB04', 'Laptop 13 inch'),
('KJB05', 'Laptop 14 inch'),
('KJB06', 'Laptop 15,6 inch');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', 'admin');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
