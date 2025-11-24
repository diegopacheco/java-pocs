CREATE STREAM purchases_stream (
    purchaseId VARCHAR KEY,
    userId VARCHAR,
    productName VARCHAR,
    productType VARCHAR,
    value DECIMAL(10,2),
    quantity INT,
    total DECIMAL(10,2)
) WITH (
    KAFKA_TOPIC='purchases',
    VALUE_FORMAT='JSON',
    PARTITIONS=1
);

CREATE TABLE purchases_dedup AS
SELECT
    purchaseId,
    LATEST_BY_OFFSET(userId) AS userId,
    LATEST_BY_OFFSET(productName) AS productName,
    LATEST_BY_OFFSET(productType) AS productType,
    LATEST_BY_OFFSET(value) AS value,
    LATEST_BY_OFFSET(quantity) AS quantity,
    LATEST_BY_OFFSET(total) AS total
FROM purchases_stream
GROUP BY purchaseId
EMIT CHANGES;

CREATE TABLE user_total_debt AS
SELECT
    userId,
    SUM(total) AS totalDebt,
    COUNT(*) AS purchaseCount
FROM purchases_dedup
GROUP BY userId
EMIT CHANGES;

CREATE TABLE user_purchase_history AS
SELECT
    userId,
    COLLECT_LIST(STRUCT(
        purchaseId := purchaseId,
        productName := productName,
        productType := productType,
        value := value,
        quantity := quantity,
        total := total
    )) AS purchases
FROM purchases_dedup
GROUP BY userId
EMIT CHANGES;
