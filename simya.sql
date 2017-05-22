-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 22 May 2017, 20:17:04
-- Sunucu sürümü: 5.7.17
-- PHP Sürümü: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `simya`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `firma`
--

CREATE TABLE `firma` (
  `fID` int(11) NOT NULL,
  `fAd` varchar(50) NOT NULL,
  `fSektor` varchar(50) NOT NULL,
  `fAdres` varchar(50) NOT NULL,
  `fTelefon` varchar(50) NOT NULL,
  `fEposta` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `isler`
--

CREATE TABLE `isler` (
  `isid` int(11) NOT NULL,
  `isadi` varchar(50) NOT NULL,
  `aciklamalar` varchar(50) NOT NULL,
  `sehir` varchar(50) NOT NULL,
  `ucret` varchar(50) NOT NULL,
  `bitistarihi` date NOT NULL,
  `calismatipi` int(5) NOT NULL,
  `ilantarihi` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uye`
--

CREATE TABLE `uye` (
  `id` int(11) NOT NULL,
  `yas` int(11) NOT NULL,
  `isim` varchar(50) NOT NULL,
  `soyisim` varchar(50) NOT NULL,
  `eposta` varchar(50) NOT NULL,
  `sifre` varchar(50) NOT NULL,
  `sehir` varchar(50) NOT NULL,
  `hakkinda` varchar(500) DEFAULT NULL,
  `ilgialanlari` varchar(500) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `firma`
--
ALTER TABLE `firma`
  ADD PRIMARY KEY (`fID`);

--
-- Tablo için indeksler `isler`
--
ALTER TABLE `isler`
  ADD PRIMARY KEY (`isid`);

--
-- Tablo için indeksler `uye`
--
ALTER TABLE `uye`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `firma`
--
ALTER TABLE `firma`
  MODIFY `fID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Tablo için AUTO_INCREMENT değeri `isler`
--
ALTER TABLE `isler`
  MODIFY `isid` int(11) NOT NULL AUTO_INCREMENT;
--
-- Tablo için AUTO_INCREMENT değeri `uye`
--
ALTER TABLE `uye`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
