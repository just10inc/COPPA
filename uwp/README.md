# CoppaLib #

## `Just10.COPPA`

 Provides static COPPA compliancy age-check methods 


---
#### `Just10.COPPA.AgeMeetsCOPPARequirements(DateTime birthdate)`

 Determines if the provided birthdate provides an age that satisfies COPPA requirements 

|Name | Description |
|-----|------|
|birthdate: |Birthdate as DateTime instance|
Returns: True if the calculated age meets COPPA requirements & False otherwise



---
#### `Just10.COPPA.AgeMeetsCOPPARequirements(long birthdate)`

 Determines if the provided birthdate provides an age that satisfies COPPA requirements 

|Name | Description |
|-----|------|
|birthdate: |Birthdate as Unix timestamp in UTC|
Returns: True if the calculated age meets COPPA requirements & False otherwise



---
#### `Just10.COPPA.AgeMeetsCOPPARequirements(string birthdate)`

 Determines if the provided birthdate provides an age that satisfies COPPA requirements 

|Name | Description |
|-----|------|
|yyyymmdd: |Birthdate as a YYYYMMDD date string|
Returns: True if the calculated age meets COPPA requirements & False otherwise



---
## `Just10.DateTimeExtensions`

 Extensions to the DateTime class to provide some needed functionality 


---
#### `Just10.DateTimeExtensions.FromMillis(long millis)`

 Convert a unix style timestamp to a DateTime object 

|Name | Description |
|-----|------|
|millis: |Timestamp in milliseconds|
Returns: The DateTime value corresponding to the provided timestamp



---
#### `Just10.DateTimeExtensions.FromString(string yyyymmdd)`

 Convert a yyyyMMdd style time string to a DateTime object 

|Name | Description |
|-----|------|
|yyyymmdd: |date string|
Returns: Corresponding DateTime value



---
#### `Just10.DateTimeExtensions.GetAge(DateTime birthdate)`

 Extension method: Gets the age associated with the birthday being the value of this DateTime object 

|Name | Description |
|-----|------|
|birthdate: |Birth date|
Returns: The age, in years



---
#### `Just10.DateTimeExtensions.AsMilliseconds(DateTime value)`

 Extension method: Convert this DateTime value to a unix style timestamp 

|Name | Description |
|-----|------|
|value: |DateTime value|
Returns: The unix timestamp (millis from epoch)



---
#### `Just10.DateTimeExtensions.AsYYYYMMDD(DateTime value)`

 Extension method: Convert this DateTime value to a yyyyMMdd string 

|Name | Description |
|-----|------|
|value: |DateTime value|
Returns: yyyyMMdd string
