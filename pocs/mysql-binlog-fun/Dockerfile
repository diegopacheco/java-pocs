FROM mysql:5.7
RUN echo "log-bin=bin.log \n\
log-bin-index=bin-log.index \n\
max_binlog_size=100M \n\
binlog_format=row \n\
socket=mysql.sock" > /etc/mysql/my.ini
RUN printf 'show_compatibility_56=ON' >> /etc/mysql/my.cfg 2>&1
CMD ["mysqld"]
