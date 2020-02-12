1.) POST data:
URL: http://localhost:8080/weather/
Request Body 1:
{
   "id":1,
   "date":"1985-02-28",
   "location":{
      "lat":36.1189,
      "lon":-86.6892,
      "city":"Nashville",
      "state":"Tennessee"
   },
   "temperature":[
      42.8,
      42.0,
      41.3,
      40.6,
      40.0,
      39.6,
      39.1,
      39.3,
      41.8,
      44.7,
      47.4,
      49.7,
      51.5,
      52.9,
      53.8,
      54.2,
      53.8,
      52.5,
      50.1,
      48.6,
      47.1,
      45.8,
      44.7,
      43.7
   ]
}

POST Request Body 2:
{
   "id":2,
   "date":"1985-01-02",
   "location":{
      "lat":36.1189,
      "lon":-86.6892,
      "city":"Nashville",
      "state":"Tennessee"
   },
   "temperature":[
      37.5,
      37.0,
      36.6,
      36.2,
      35.9,
      35.5,
      35.3,
      35.2,
      36.1,
      38.3,
      40.6,
      42.7,
      44.2,
      45.3,
      46.0,
      46.1,
      45.3,
      43.3,
      42.0,
      41.2,
      40.3,
      39.6,
      39.0,
      38.4
   ]
}

POST Request Body 3:
{
   "id":9,
   "date":"1985-01-01",
   "location":{
      "lat":32.5,
      "lon":-93.6667,
      "city":"Shreveport",
      "state":"Louisiana"
   },
   "temperature":[
      53.6,
      53.6,
      53.6,
      53.6,
      53.6,
      53.6,
      39.4,
      39.4,
      40.1,
      42.9,
      45.8,
      48.5,
      50.3,
      52.0,
      53.2,
      53.6,
      53.4,
      51.6,
      48.8,
      46.8,
      45.5,
      44.5,
      53.6,
      53.6
   ]
}

2.) Get All data:
URL: http://localhost:8080/weather/

3.) Get Data by Date
URL: http://localhost:8080/weather?date=1985-01-01

4.) Delete all Date
URL: http://localhost:8080/erase/

5.) Delete data where location coordinates are given and recordedDate between given start and end dates
URL: http://localhost:8080/erase?start=1984-01-01&end=1985-12-01&lat=36.1189&lon=-86.6892
