{
	"info": {
		"_postman_id": "5d990327-ba11-4f18-936d-10f9babca1d8",
		"name": "Lib",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "33347729"
	},
	"item": [
		{
			"name": "Book",
			"item": [
				{
					"name": "Get all books",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{api}}/books",
							"host": [
								"{{api}}"
							],
							"path": [
								"books"
							]
						}
					},
					"response": [
						{
							"name": "Get all books",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "localhost:8080/api/books",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"books"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 16:02:30 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "[\n    {\n        \"id\": 1,\n        \"title\": \"The Great Gatsby\",\n        \"author\": \"F. Scott Fitzgerald\",\n        \"isbn\": \"9780743273565\",\n        \"publication_year\": 1925,\n        \"copies\": 12\n    },\n    {\n        \"id\": 2,\n        \"title\": \"To Kill a Mockingbird\",\n        \"author\": \"Harper Lee\",\n        \"isbn\": \"9780061120084\",\n        \"publication_year\": 1960,\n        \"copies\": 10\n    },\n    {\n        \"id\": 3,\n        \"title\": \"1984\",\n        \"author\": \"George Orwell\",\n        \"isbn\": \"9780451524935\",\n        \"publication_year\": 1949,\n        \"copies\": 14\n    },\n    {\n        \"id\": 4,\n        \"title\": \"Pride and Prejudice\",\n        \"author\": \"Jane Austen\",\n        \"isbn\": \"9780679783268\",\n        \"publication_year\": 1813,\n        \"copies\": 40\n    },\n    {\n        \"id\": 5,\n        \"title\": \"The Catcher in the Rye\",\n        \"author\": \"J.D. Salinger\",\n        \"isbn\": \"9780316769488\",\n        \"publication_year\": 1951,\n        \"copies\": 49\n    },\n    {\n        \"id\": 6,\n        \"title\": \"The Hobbit\",\n        \"author\": \"J.R.R. Tolkien\",\n        \"isbn\": \"9780618260300\",\n        \"publication_year\": 1937,\n        \"copies\": 38\n    },\n    {\n        \"id\": 7,\n        \"title\": \"The Lord of the Rings\",\n        \"author\": \"J.R.R. Tolkien\",\n        \"isbn\": \"9780618640157\",\n        \"publication_year\": 1954,\n        \"copies\": 34\n    },\n    {\n        \"id\": 8,\n        \"title\": \"Animal Farm\",\n        \"author\": \"George Orwell\",\n        \"isbn\": \"9780451526342\",\n        \"publication_year\": 1945,\n        \"copies\": 4\n    },\n    {\n        \"id\": 9,\n        \"title\": \"The Little Prince\",\n        \"author\": \"Antoine de Saint-Exupéry\",\n        \"isbn\": \"9780156012195\",\n        \"publication_year\": 1943,\n        \"copies\": 9\n    },\n    {\n        \"id\": 10,\n        \"title\": \"The Da Vinci Code\",\n        \"author\": \"Dan Brown\",\n        \"isbn\": \"9780307474278\",\n        \"publication_year\": 2003,\n        \"copies\": 69\n    },\n    {\n        \"id\": 11,\n        \"title\": \"The Alchemist\",\n        \"author\": \"Paulo Coelho\",\n        \"isbn\": \"9780061122415\",\n        \"publication_year\": 1988,\n        \"copies\": 23\n    }\n]"
						}
					]
				},
				{
					"name": "Get book by id",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{api}}/books/1",
							"host": [
								"{{api}}"
							],
							"path": [
								"books",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "Get book by id",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "localhost:8080/api/books/1",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"books",
										"1"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 16:03:10 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"id\": 1,\n    \"title\": \"The Great Gatsby\",\n    \"author\": \"F. Scott Fitzgerald\",\n    \"isbn\": \"9780743273565\",\n    \"publication_year\": 1925,\n    \"copies\": 12\n}"
						}
					]
				},
				{
					"name": "Add a book",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "  {\n    \"title\": \"Animal Farm\",\n    \"author\": \"George Orwell\",\n    \"publication_year\": 1945,\n    \"copies\": 4,\n    \"isbn\": \"9780451526341\"\n  }",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{api}}/books",
							"host": [
								"{{api}}"
							],
							"path": [
								"books"
							]
						}
					},
					"response": [
						{
							"name": "Add a book",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "  {\n    \"title\": \"How to not give a damn?\",\n    \"author\": \"Oliver Mankind\",\n    \"publication_year\": 2024,\n    \"copies\": 1,\n    \"isbn\": \"9720451526341\"\n  }",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "{{api}}/books",
									"host": [
										"{{api}}"
									],
									"path": [
										"books"
									]
								}
							},
							"status": "Created",
							"code": 201,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Content-Length",
									"value": "0"
								},
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 16:08:18 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						}
					]
				},
				{
					"name": "Delete a book",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "{{api}}/books/15",
							"host": [
								"{{api}}"
							],
							"path": [
								"books",
								"15"
							]
						}
					},
					"response": [
						{
							"name": "Delete a book",
							"originalRequest": {
								"method": "DELETE",
								"header": [],
								"url": {
									"raw": "localhost:8080/api/books/15",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"books",
										"15"
									]
								}
							},
							"status": "No Content",
							"code": 204,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 16:13:31 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						}
					]
				},
				{
					"name": "Update a book",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"title\": \"The Great Gatsby\",\n    \"author\": \"F. Scott Fitzgerald\",\n    \"isbn\": \"9780743273562\",\n    \"publication_year\": 1925,\n    \"copies\": 120\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{api}}/books/14",
							"host": [
								"{{api}}"
							],
							"path": [
								"books",
								"14"
							]
						}
					},
					"response": [
						{
							"name": "Update a book",
							"originalRequest": {
								"method": "PUT",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\n    \"title\": \"The Great Gatsby\",\n    \"author\": \"F. Scott Fitzgerald\",\n    \"isbn\": \"9780743273562\",\n    \"publication_year\": 1925,\n    \"copies\": 120\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "localhost:8080/api/books/14",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"books",
										"14"
									]
								}
							},
							"status": "No Content",
							"code": 204,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 17:25:10 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						}
					]
				}
			]
		},
		{
			"name": "Patron",
			"item": [
				{
					"name": "Get all patrons",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{api}}/patrons",
							"host": [
								"{{api}}"
							],
							"path": [
								"patrons"
							]
						}
					},
					"response": [
						{
							"name": "Get all partons",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "localhost:8080/api/patrons",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"patrons"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 16:26:21 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "[\n    {\n        \"id\": 1,\n        \"name\": \"John Doe\",\n        \"email\": \"john@doe.com\",\n        \"password\": \"password\"\n    }\n]"
						}
					]
				},
				{
					"name": "Add a patron",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"name\": \"John Doe\",\n    \"email\": \"john@doe.com\",\n    \"password\": \"password\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{api}}/patrons",
							"host": [
								"{{api}}"
							],
							"path": [
								"patrons"
							]
						}
					},
					"response": [
						{
							"name": "Add a parton",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\n    \"name\": \"John Doe\",\n    \"email\": \"john@doe.com\",\n    \"password\": \"password\"\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "localhost:8080/api/patrons",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"patrons"
									]
								}
							},
							"status": "Created",
							"code": 201,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Content-Length",
									"value": "0"
								},
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 16:26:16 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						}
					]
				},
				{
					"name": "Get patron by id",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "{{api}}/patrons/1",
							"host": [
								"{{api}}"
							],
							"path": [
								"patrons",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "Get a patron by id",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "localhost:8080/api/patrons/1",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"patrons",
										"1"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 16:42:07 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"id\": 1,\n    \"name\": \"John Doe\",\n    \"email\": \"john@doe.com\",\n    \"password\": \"password\"\n}"
						}
					]
				},
				{
					"name": "Update a patron",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"name\": \"John Doe\",\n    \"email\": \"john@doe.com\",\n    \"password\": \"updated\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "{{api}}/patrons/1",
							"host": [
								"{{api}}"
							],
							"path": [
								"patrons",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "New Request",
							"originalRequest": {
								"method": "PUT",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\n    \"name\": \"John Doe\",\n    \"email\": \"john@doe.com\",\n    \"password\": \"updated\"\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "{{api}}/patrons/1",
									"host": [
										"{{api}}"
									],
									"path": [
										"patrons",
										"1"
									]
								}
							},
							"status": "No Content",
							"code": 204,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 17:29:06 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						}
					]
				}
			]
		},
		{
			"name": "Borrow",
			"item": [
				{
					"name": "Borrow a book",
					"request": {
						"method": "POST",
						"header": [],
						"url": {
							"raw": "{{api}}/borrow/2/patron/1",
							"host": [
								"{{api}}"
							],
							"path": [
								"borrow",
								"2",
								"patron",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "Borrow a book",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"url": {
									"raw": "localhost:8080/api/borrow/8/patron/1",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"borrow",
										"8",
										"patron",
										"1"
									]
								}
							},
							"status": "Created",
							"code": 201,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Content-Length",
									"value": "0"
								},
								{
									"key": "Date",
									"value": "Wed, 07 Aug 2024 19:50:41 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						}
					]
				},
				{
					"name": "Return a book",
					"request": {
						"method": "PUT",
						"header": [],
						"url": {
							"raw": "{{api}}/return/2/patron/1",
							"host": [
								"{{api}}"
							],
							"path": [
								"return",
								"2",
								"patron",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "Return a book",
							"originalRequest": {
								"method": "PUT",
								"header": [],
								"url": {
									"raw": "{{api}}/return/2/patron/1",
									"host": [
										"{{api}}"
									],
									"path": [
										"return",
										"2",
										"patron",
										"1"
									]
								}
							},
							"status": "No Content",
							"code": 204,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Date",
									"value": "Thu, 08 Aug 2024 09:09:29 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						}
					]
				}
			]
		}
	],
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"type": "text/javascript",
				"packages": {},
				"exec": [
					""
				]
			}
		},
		{
			"listen": "test",
			"script": {
				"type": "text/javascript",
				"packages": {},
				"exec": [
					""
				]
			}
		}
	],
	"variable": [
		{
			"key": "api",
			"value": "localhost:8080/api",
			"type": "string"
		}
	]
}