#!/usr/bin/python
import urllib, json

metadataEndpoint = "http://169.254.170.2/v2/metadata"
metadata = urllib.urlopen(metadataEndpoint)
metadataJson = json.loads(metadata.read())
print (metadataJson['Containers'][0]['Networks'][0]['IPv4Addresses'][0])
