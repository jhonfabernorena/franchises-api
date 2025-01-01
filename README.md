# Franchise Management API

## Description

API developed with Spring Boot 3.4.1 to manage franchises, vendors, and products.

## Requirements

- Java 23
- Maven 3.8+
- MongoDB Atlas

## Configuration

### Environment Variables

Edit the `application.properties` file located in `src/main/resources`:

```
spring.data.mongodb.uri=mongodb+srv://dbfranquiciasapi:0VCPA9JvtGJrMM9V@franquicias-api.b5pvp.mongodb.net/franquicias-db
spring.data.mongodb.database=franquicias-db

server.port=8080
```

## Run Application

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

## Endpoints

### Franchise

- **POST /api/franchises** - Add a new franchise.
- **GET /api/franchises** - Get all franchises.
- **GET /api/franchises/{id}** - Get a franchise by ID.

### Vendor

- **POST /api/vendors/{franchiseId}** - Add a new vendor to a franchise.

### Product

- **POST /api/products/{vendorId}** - Add a new product to a vendor.
- **DELETE /api/products/{vendorId}/{productName}** - Remove a product from a vendor.
- **PUT /api/products/{vendorId}/{productName}?stock=10** - Update the stock of a product.

## Testing

```bash
mvn test
```

## Docker Build

```bash
docker build -t franchise-api .
```

## Docker Run

```bash
docker run -p 8080:8080 franchise-api
```

