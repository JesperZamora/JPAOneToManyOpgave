# JPAOneToManyOpgave
OneToMany / ManyToOne - assigment: Fetching data from apis

- Using Postman for endpoint testing
 <br>
 <br>
 
## Endpoints - in assignment 1::
#### getAllRegions - fetched directly from the api
localhost:8080/regioner

 <br>
 
#### getKommuner - fetched directly from the api
localhost:8080/kommuner

 <br>
 
#### getAllRegionsByNameOrCode - get all by name, code or just some part of the name or code.
localhost:8080/regioner/jylland <br>
localhost:8080/regioner/1081  <br>
localhost:8080/regioner/foo  <br>

"jylland"

    [
        {
            "kode": "1081",
            "navn": "Region Nordjylland",
            "href": "https://api.dataforsyningen.dk/regioner/1081"
        },
        {
            "kode": "1082",
            "navn": "Region Midtjylland",
            "href": "https://api.dataforsyningen.dk/regioner/1082"
        }
    ]


<br>

"1081"

    [
    {
        "kode": "1081",
        "navn": "Region Nordjylland",
        "href": "https://api.dataforsyningen.dk/regioner/1081"
    }
    ]

 <br>
 
#### postRegion
localhost:8080/regioner/add

    {
        "kode": "2000",
        "navn": "Region Metropolis",
        "href": "https://api.dataforsyningen.dk/regioner/2000"
    }

 <br>
 
### putRegion
localhost:8080/regioner/2000/edit

    {
        "navn": "Region Gotham City",
        "href": "https://api.dataforsyningen.dk/regioner/2001"
    }

 <br>

### deleteRegion
localhost:8080/regioner/2001/delete

<br>

# Endpoint - in assignment 2::
#### getKommuneNamesByRegionCode
localhost:8080/kommunenavne/1081

    {
        "names": [
            "Brønderslev",
            "Hjørring",
            "Thisted",
            "Læsø",
            "Morsø",
            "Aalborg",
            "Vesthimmerlands",
            "Rebild",
            "Jammerbugt",
            "Frederikshavn",
            "Mariagerfjord"
        ]
    }
 
