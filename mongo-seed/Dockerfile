FROM mongo

COPY init.json /init.json
CMD mongoimport --host mongodb --db quotes --collection quotes --type json --file /init.json --jsonArray