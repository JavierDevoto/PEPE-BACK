# PEPE-BACK
The best eCommerce ever. (We are not kidding)

## Item's Format

#### Item without variant
```json
{
  "id": 12312,
  "title": "Pijama Bebe",
  "subtitle": "Pijama re loco para bebe",
  "price": 2500,
  "hard_price": 100,
  "available_quantity": 12,
  "status": "ACTIVE",
  "attributes": [
    {
      "type": "COLOR",
      "value": "ffffff",
      "h_r_value": "Negro"
    },
    {
      "type": "FABRIC",
      "value": "Algodón",
      "h_r_value": "Algodón"
    }
  ],
  "available_variants": [],
  "variants": [],
  "small_pictures": [
    "https://www.photos.locas.com/pijama"
  ],
  "pictures": [
    "https://www.photos.locas.com/pijama"
  ],
  "videos": [
    "https://www.videos.showcase.com/pijama-moviendose"
  ],
  "tags": [
    "SUMMER",
    "SHORT",
    "COTTON"
  ],
  "permalink": "https://www.pijamas.com/items/12312",
  "date_created": "23-12-1992T12:15:00",
  "last_updated": "23-12-1992T12:15:00"
}
```

#### Item with 2 variants

```json
{
  "id": 18468,
  "title": "Pijama Bebe",
  "subtitle": "Pijama re loco para bebe",
  "price": 2500,
  "hard_price": 100,
  "available_quantity": 3,
  "status": "ACTIVE",
  "attributes": [],
  "available_variants": [
    "COLOR",
    "SIZE"
  ],
  "variants": [
    {
      "id": 333,
      "price": 2510,
      "hard_price": 101,
      "available_quantity": 1,
      "small_pictures": [
        "https://www.photos.locas.com/pijama-l"
      ],
      "pictures": [
        "https://www.photos.locas.com/pijama-l"
      ],
      "videos": [
        "https://www.videos.showcase.com/pijama-moviendose-l"
      ],
      "variant": [
        {
          "type": "COLOR",
          "value": "eeeeee",
          "h_r_value": "Gris"
        },
        {
          "type": "SIZE",
          "value": "L",
          "h_r_value": "Largo"
        }
      ],
      "attributes": [
        {
          "type": "BRAND",
          "value": "Lacoste",
          "h_r_value": "Lacoste"
        }
      ]
    },
    {
      "id": 44,
      "price": 2400,
      "hard_price": 98,
      "available_quantity": 5,
      "small_pictures": [
        "https://www.photos.locas.com/pijama-m"
      ],
      "pictures": [
        "https://www.photos.locas.com/pijama-m"
      ],
      "videos": [
        "https://www.videos.showcase.com/pijama-moviendose-m"
      ],
      "variant": [
        {
          "type": "COLOR",
          "value": "eeeeee",
          "h_r_value": "Gris"
        },
        {
          "type": "SIZE",
          "value": "M",
          "h_r_value": "Medium"
        }
      ],
      "attributes": [
        {
          "type": "BRAND",
          "value": "Lacoste",
          "h_r_value": "Lacoste"
        }
      ]
    }
  ],
  "small_pictures": [],
  "pictures": [],
  "videos": [],
  "tags": [
    "SUMMER",
    "SHORT"
  ],
  "permalink": "https://www.pijamas.com/items/18468",
  "date_created": "23-12-1992T12:15:00",
  "last_updated": "23-12-1992T12:15:00"
}
```