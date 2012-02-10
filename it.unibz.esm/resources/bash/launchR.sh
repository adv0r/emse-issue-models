#!/bin/sh
mkdir /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/
mkdir /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467//img
R < /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/resources/r/r.in.txt --no-save > /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/r.out.txt
mv /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/Rplots* /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/
sips -s format jpeg -s formatOptions 100 -Z 600 /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/Rplots.pdf --out /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/img/Apache_httpd_1.3_box.jpg  > /dev/null
sips -s format jpeg -s formatOptions 100 -Z 600 /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/Rplots1.pdf --out /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/img/Apache_httpd_1.3_earlyLate.jpg  > /dev/null
sips -s format jpeg -s formatOptions 100 -Z 600 /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/Rplots2.pdf --out /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/img/Apache_httpd_1.3_increment.jpg  > /dev/null
rm /Users/Adva/Desktop/repository/esm/dev/workspace/it.unibz.esm/output/Report_1307908670467/Rplots*pdf
