#!/bin/sh
mkdir /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/
mkdir /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965//img
R < /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/resources/r/r.in.txt --no-save > /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/r.out.txt
mv /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/Rplots* /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/
sips -s format jpeg -s formatOptions 100 -Z 600 /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/Rplots.pdf --out /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/img/Tomcat_5_box.jpg  > /dev/null
sips -s format jpeg -s formatOptions 100 -Z 600 /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/Rplots1.pdf --out /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/img/Tomcat_5_earlyLate.jpg  > /dev/null
sips -s format jpeg -s formatOptions 100 -Z 600 /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/Rplots2.pdf --out /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/img/Tomcat_5_increment.jpg  > /dev/null
rm /Users/Adva/Desktop/repository/esm/releases/it.unibz.esm/output/Report_1307915685965/Rplots*pdf
