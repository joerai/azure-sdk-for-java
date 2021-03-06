/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.azure.management.storage;

import com.microsoft.azure.management.storage.models.AccountStatus;
import com.microsoft.azure.management.storage.models.AccountType;
import com.microsoft.azure.management.storage.models.CustomDomain;
import com.microsoft.azure.management.storage.models.Endpoints;
import com.microsoft.azure.management.storage.models.KeyName;
import com.microsoft.azure.management.storage.models.ProvisioningState;
import com.microsoft.azure.management.storage.models.StorageAccount;
import com.microsoft.azure.management.storage.models.StorageAccountCreateResponse;
import com.microsoft.windowsazure.core.OperationStatus;
import com.microsoft.windowsazure.core.ServiceClient;
import com.microsoft.windowsazure.credentials.SubscriptionCloudCredentials;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.configuration.ManagementConfiguration;
import com.microsoft.windowsazure.tracing.CloudTracing;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.NullNode;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
* The Storage Management Client.
*/
public class StorageManagementClientImpl extends ServiceClient<StorageManagementClient> implements StorageManagementClient {
    private String apiVersion;
    
    /**
    * Gets the API version.
    * @return The ApiVersion value.
    */
    public String getApiVersion() {
        return this.apiVersion;
    }
    
    private URI baseUri;
    
    /**
    * Gets the URI used as the base for all cloud service requests.
    * @return The BaseUri value.
    */
    public URI getBaseUri() {
        return this.baseUri;
    }
    
    private SubscriptionCloudCredentials credentials;
    
    /**
    * Gets subscription credentials which uniquely identify Microsoft Azure
    * subscription. The subscription ID forms part of the URI for every
    * service call.
    * @return The Credentials value.
    */
    public SubscriptionCloudCredentials getCredentials() {
        return this.credentials;
    }
    
    private int longRunningOperationInitialTimeout;
    
    /**
    * Gets or sets the initial timeout for Long Running Operations.
    * @return The LongRunningOperationInitialTimeout value.
    */
    public int getLongRunningOperationInitialTimeout() {
        return this.longRunningOperationInitialTimeout;
    }
    
    /**
    * Gets or sets the initial timeout for Long Running Operations.
    * @param longRunningOperationInitialTimeoutValue The
    * LongRunningOperationInitialTimeout value.
    */
    public void setLongRunningOperationInitialTimeout(final int longRunningOperationInitialTimeoutValue) {
        this.longRunningOperationInitialTimeout = longRunningOperationInitialTimeoutValue;
    }
    
    private int longRunningOperationRetryTimeout;
    
    /**
    * Gets or sets the retry timeout for Long Running Operations.
    * @return The LongRunningOperationRetryTimeout value.
    */
    public int getLongRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }
    
    /**
    * Gets or sets the retry timeout for Long Running Operations.
    * @param longRunningOperationRetryTimeoutValue The
    * LongRunningOperationRetryTimeout value.
    */
    public void setLongRunningOperationRetryTimeout(final int longRunningOperationRetryTimeoutValue) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeoutValue;
    }
    
    private StorageAccountOperations storageAccounts;
    
    /**
    * Operations for managing storage accounts.
    * @return The StorageAccountsOperations value.
    */
    public StorageAccountOperations getStorageAccountsOperations() {
        return this.storageAccounts;
    }
    
    /**
    * Initializes a new instance of the StorageManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    */
    public StorageManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService) {
        super(httpBuilder, executorService);
        this.storageAccounts = new StorageAccountOperationsImpl(this);
        this.apiVersion = "2015-05-01-preview";
        this.longRunningOperationInitialTimeout = -1;
        this.longRunningOperationRetryTimeout = -1;
    }
    
    /**
    * Initializes a new instance of the StorageManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    * @param credentials Required. Gets subscription credentials which uniquely
    * identify Microsoft Azure subscription. The subscription ID forms part of
    * the URI for every service call.
    * @param baseUri Optional. Gets the URI used as the base for all cloud
    * service requests.
    */
    @Inject
    public StorageManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService, @Named(ManagementConfiguration.SUBSCRIPTION_CLOUD_CREDENTIALS) SubscriptionCloudCredentials credentials, @Named(ManagementConfiguration.URI) URI baseUri) {
        this(httpBuilder, executorService);
        if (credentials == null) {
            throw new NullPointerException("credentials");
        } else {
            this.credentials = credentials;
        }
        if (baseUri == null) {
            try {
                this.baseUri = new URI("https://management.azure.com/");
            }
            catch (URISyntaxException ex) {
            }
        } else {
            this.baseUri = baseUri;
        }
    }
    
    /**
    * Initializes a new instance of the StorageManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    * @param credentials Required. Gets subscription credentials which uniquely
    * identify Microsoft Azure subscription. The subscription ID forms part of
    * the URI for every service call.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    */
    public StorageManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService, SubscriptionCloudCredentials credentials) throws URISyntaxException {
        this(httpBuilder, executorService);
        if (credentials == null) {
            throw new NullPointerException("credentials");
        }
        this.credentials = credentials;
        this.baseUri = new URI("https://management.azure.com/");
    }
    
    /**
    * Initializes a new instance of the StorageManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    * @param credentials Required. Gets subscription credentials which uniquely
    * identify Microsoft Azure subscription. The subscription ID forms part of
    * the URI for every service call.
    * @param baseUri Optional. Gets the URI used as the base for all cloud
    * service requests.
    * @param apiVersion Optional. Gets the API version.
    * @param longRunningOperationInitialTimeout Required. Gets or sets the
    * initial timeout for Long Running Operations.
    * @param longRunningOperationRetryTimeout Required. Gets or sets the retry
    * timeout for Long Running Operations.
    */
    public StorageManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService, SubscriptionCloudCredentials credentials, URI baseUri, String apiVersion, int longRunningOperationInitialTimeout, int longRunningOperationRetryTimeout) {
        this(httpBuilder, executorService);
        this.credentials = credentials;
        this.baseUri = baseUri;
        this.apiVersion = apiVersion;
        this.longRunningOperationInitialTimeout = longRunningOperationInitialTimeout;
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
    }
    
    /**
    * Initializes a new instance of the StorageManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    */
    protected StorageManagementClientImpl newInstance(HttpClientBuilder httpBuilder, ExecutorService executorService) {
        return new StorageManagementClientImpl(httpBuilder, executorService, this.getCredentials(), this.getBaseUri(), this.getApiVersion(), this.getLongRunningOperationInitialTimeout(), this.getLongRunningOperationRetryTimeout());
    }
    
    /**
    * Parse enum values for type AccountType.
    *
    * @param value The value to parse.
    * @return The enum value.
    */
     static AccountType parseAccountType(String value) {
        if ("Standard_LRS".equalsIgnoreCase(value)) {
            return AccountType.StandardLRS;
        }
        if ("Standard_ZRS".equalsIgnoreCase(value)) {
            return AccountType.StandardZRS;
        }
        if ("Standard_GRS".equalsIgnoreCase(value)) {
            return AccountType.StandardGRS;
        }
        if ("Standard_RAGRS".equalsIgnoreCase(value)) {
            return AccountType.StandardRAGRS;
        }
        if ("Premium_LRS".equalsIgnoreCase(value)) {
            return AccountType.PremiumLRS;
        }
        throw new IllegalArgumentException("value");
    }
    
    /**
    * Convert an enum of type AccountType to a string.
    *
    * @param value The value to convert to a string.
    * @return The enum value as a string.
    */
     static String accountTypeToString(AccountType value) {
        if (value == AccountType.StandardLRS) {
            return "Standard_LRS";
        }
        if (value == AccountType.StandardZRS) {
            return "Standard_ZRS";
        }
        if (value == AccountType.StandardGRS) {
            return "Standard_GRS";
        }
        if (value == AccountType.StandardRAGRS) {
            return "Standard_RAGRS";
        }
        if (value == AccountType.PremiumLRS) {
            return "Premium_LRS";
        }
        throw new IllegalArgumentException("value");
    }
    
    /**
    * Parse enum values for type KeyName.
    *
    * @param value The value to parse.
    * @return The enum value.
    */
     static KeyName parseKeyName(String value) {
        if ("key1".equalsIgnoreCase(value)) {
            return KeyName.Key1;
        }
        if ("key2".equalsIgnoreCase(value)) {
            return KeyName.Key2;
        }
        throw new IllegalArgumentException("value");
    }
    
    /**
    * Convert an enum of type KeyName to a string.
    *
    * @param value The value to convert to a string.
    * @return The enum value as a string.
    */
     static String keyNameToString(KeyName value) {
        if (value == KeyName.Key1) {
            return "key1";
        }
        if (value == KeyName.Key2) {
            return "key2";
        }
        throw new IllegalArgumentException("value");
    }
    
    /**
    * The Get Create Operation Status operation returns the status of the
    * specified create operation. After calling the asynchronous Begin Create
    * operation, you can call Get Create Operation Status to determine whether
    * the operation has succeeded, failed, or is still in progress.
    *
    * @param operationStatusLink Required. The URL where the status of the
    * long-running create operation can be checked.
    * @return The Create storage account operation response.
    */
    @Override
    public Future<StorageAccountCreateResponse> getCreateOperationStatusAsync(final String operationStatusLink) {
        return this.getExecutorService().submit(new Callable<StorageAccountCreateResponse>() { 
            @Override
            public StorageAccountCreateResponse call() throws Exception {
                return getCreateOperationStatus(operationStatusLink);
            }
         });
    }
    
    /**
    * The Get Create Operation Status operation returns the status of the
    * specified create operation. After calling the asynchronous Begin Create
    * operation, you can call Get Create Operation Status to determine whether
    * the operation has succeeded, failed, or is still in progress.
    *
    * @param operationStatusLink Required. The URL where the status of the
    * long-running create operation can be checked.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return The Create storage account operation response.
    */
    @Override
    public StorageAccountCreateResponse getCreateOperationStatus(String operationStatusLink) throws IOException, ServiceException, URISyntaxException {
        // Validate
        if (operationStatusLink == null) {
            throw new NullPointerException("operationStatusLink");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("operationStatusLink", operationStatusLink);
            CloudTracing.enter(invocationId, this, "getCreateOperationStatusAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "";
        url = url + operationStatusLink;
        url = url.replace(" ", "%20");
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-client-request-id", UUID.randomUUID().toString());
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK && statusCode != HttpStatus.SC_ACCEPTED && statusCode != HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                ServiceException ex = ServiceException.createFromJson(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            StorageAccountCreateResponse result = null;
            // Deserialize Response
            if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_ACCEPTED || statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                InputStream responseContent = httpResponse.getEntity().getContent();
                result = new StorageAccountCreateResponse();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode responseDoc = null;
                String responseDocContent = IOUtils.toString(responseContent);
                if (responseDocContent == null == false && responseDocContent.length() > 0) {
                    responseDoc = objectMapper.readTree(responseDocContent);
                }
                
                if (responseDoc != null && responseDoc instanceof NullNode == false) {
                    StorageAccount storageAccountInstance = new StorageAccount();
                    result.setStorageAccount(storageAccountInstance);
                    
                    JsonNode idValue = responseDoc.get("id");
                    if (idValue != null && idValue instanceof NullNode == false) {
                        String idInstance;
                        idInstance = idValue.getTextValue();
                        storageAccountInstance.setId(idInstance);
                    }
                    
                    JsonNode nameValue = responseDoc.get("name");
                    if (nameValue != null && nameValue instanceof NullNode == false) {
                        String nameInstance;
                        nameInstance = nameValue.getTextValue();
                        storageAccountInstance.setName(nameInstance);
                    }
                    
                    JsonNode typeValue = responseDoc.get("type");
                    if (typeValue != null && typeValue instanceof NullNode == false) {
                        String typeInstance;
                        typeInstance = typeValue.getTextValue();
                        storageAccountInstance.setType(typeInstance);
                    }
                    
                    JsonNode locationValue = responseDoc.get("location");
                    if (locationValue != null && locationValue instanceof NullNode == false) {
                        String locationInstance;
                        locationInstance = locationValue.getTextValue();
                        storageAccountInstance.setLocation(locationInstance);
                    }
                    
                    JsonNode tagsSequenceElement = ((JsonNode) responseDoc.get("tags"));
                    if (tagsSequenceElement != null && tagsSequenceElement instanceof NullNode == false) {
                        Iterator<Map.Entry<String, JsonNode>> itr = tagsSequenceElement.getFields();
                        while (itr.hasNext()) {
                            Map.Entry<String, JsonNode> property = itr.next();
                            String tagsKey = property.getKey();
                            String tagsValue = property.getValue().getTextValue();
                            storageAccountInstance.getTags().put(tagsKey, tagsValue);
                        }
                    }
                    
                    JsonNode propertiesValue = responseDoc.get("properties");
                    if (propertiesValue != null && propertiesValue instanceof NullNode == false) {
                        JsonNode provisioningStateValue = propertiesValue.get("provisioningState");
                        if (provisioningStateValue != null && provisioningStateValue instanceof NullNode == false) {
                            ProvisioningState provisioningStateInstance;
                            provisioningStateInstance = Enum.valueOf(ProvisioningState.class, provisioningStateValue.getTextValue());
                            storageAccountInstance.setProvisioningState(provisioningStateInstance);
                        }
                        
                        JsonNode accountTypeValue = propertiesValue.get("accountType");
                        if (accountTypeValue != null && accountTypeValue instanceof NullNode == false) {
                            AccountType accountTypeInstance;
                            accountTypeInstance = com.microsoft.azure.management.storage.StorageManagementClientImpl.parseAccountType(accountTypeValue.getTextValue());
                            storageAccountInstance.setAccountType(accountTypeInstance);
                        }
                        
                        JsonNode primaryEndpointsValue = propertiesValue.get("primaryEndpoints");
                        if (primaryEndpointsValue != null && primaryEndpointsValue instanceof NullNode == false) {
                            Endpoints primaryEndpointsInstance = new Endpoints();
                            storageAccountInstance.setPrimaryEndpoints(primaryEndpointsInstance);
                            
                            JsonNode blobValue = primaryEndpointsValue.get("blob");
                            if (blobValue != null && blobValue instanceof NullNode == false) {
                                URI blobInstance;
                                blobInstance = new URI(blobValue.getTextValue());
                                primaryEndpointsInstance.setBlob(blobInstance);
                            }
                            
                            JsonNode queueValue = primaryEndpointsValue.get("queue");
                            if (queueValue != null && queueValue instanceof NullNode == false) {
                                URI queueInstance;
                                queueInstance = new URI(queueValue.getTextValue());
                                primaryEndpointsInstance.setQueue(queueInstance);
                            }
                            
                            JsonNode tableValue = primaryEndpointsValue.get("table");
                            if (tableValue != null && tableValue instanceof NullNode == false) {
                                URI tableInstance;
                                tableInstance = new URI(tableValue.getTextValue());
                                primaryEndpointsInstance.setTable(tableInstance);
                            }
                        }
                        
                        JsonNode primaryLocationValue = propertiesValue.get("primaryLocation");
                        if (primaryLocationValue != null && primaryLocationValue instanceof NullNode == false) {
                            String primaryLocationInstance;
                            primaryLocationInstance = primaryLocationValue.getTextValue();
                            storageAccountInstance.setPrimaryLocation(primaryLocationInstance);
                        }
                        
                        JsonNode statusOfPrimaryValue = propertiesValue.get("statusOfPrimary");
                        if (statusOfPrimaryValue != null && statusOfPrimaryValue instanceof NullNode == false) {
                            AccountStatus statusOfPrimaryInstance;
                            statusOfPrimaryInstance = Enum.valueOf(AccountStatus.class, statusOfPrimaryValue.getTextValue());
                            storageAccountInstance.setStatusOfPrimary(statusOfPrimaryInstance);
                        }
                        
                        JsonNode lastGeoFailoverTimeValue = propertiesValue.get("lastGeoFailoverTime");
                        if (lastGeoFailoverTimeValue != null && lastGeoFailoverTimeValue instanceof NullNode == false) {
                            Calendar lastGeoFailoverTimeInstance;
                            lastGeoFailoverTimeInstance = DatatypeConverter.parseDateTime(lastGeoFailoverTimeValue.getTextValue());
                            storageAccountInstance.setLastGeoFailoverTime(lastGeoFailoverTimeInstance);
                        }
                        
                        JsonNode secondaryLocationValue = propertiesValue.get("secondaryLocation");
                        if (secondaryLocationValue != null && secondaryLocationValue instanceof NullNode == false) {
                            String secondaryLocationInstance;
                            secondaryLocationInstance = secondaryLocationValue.getTextValue();
                            storageAccountInstance.setSecondaryLocation(secondaryLocationInstance);
                        }
                        
                        JsonNode statusOfSecondaryValue = propertiesValue.get("statusOfSecondary");
                        if (statusOfSecondaryValue != null && statusOfSecondaryValue instanceof NullNode == false) {
                            AccountStatus statusOfSecondaryInstance;
                            statusOfSecondaryInstance = Enum.valueOf(AccountStatus.class, statusOfSecondaryValue.getTextValue());
                            storageAccountInstance.setStatusOfSecondary(statusOfSecondaryInstance);
                        }
                        
                        JsonNode creationTimeValue = propertiesValue.get("creationTime");
                        if (creationTimeValue != null && creationTimeValue instanceof NullNode == false) {
                            Calendar creationTimeInstance;
                            creationTimeInstance = DatatypeConverter.parseDateTime(creationTimeValue.getTextValue());
                            storageAccountInstance.setCreationTime(creationTimeInstance);
                        }
                        
                        JsonNode customDomainValue = propertiesValue.get("customDomain");
                        if (customDomainValue != null && customDomainValue instanceof NullNode == false) {
                            CustomDomain customDomainInstance = new CustomDomain();
                            storageAccountInstance.setCustomDomain(customDomainInstance);
                            
                            JsonNode nameValue2 = customDomainValue.get("name");
                            if (nameValue2 != null && nameValue2 instanceof NullNode == false) {
                                String nameInstance2;
                                nameInstance2 = nameValue2.getTextValue();
                                customDomainInstance.setName(nameInstance2);
                            }
                            
                            JsonNode useSubDomainValue = customDomainValue.get("useSubDomain");
                            if (useSubDomainValue != null && useSubDomainValue instanceof NullNode == false) {
                                boolean useSubDomainInstance;
                                useSubDomainInstance = useSubDomainValue.getBooleanValue();
                                customDomainInstance.setUseSubDomain(useSubDomainInstance);
                            }
                        }
                        
                        JsonNode secondaryEndpointsValue = propertiesValue.get("secondaryEndpoints");
                        if (secondaryEndpointsValue != null && secondaryEndpointsValue instanceof NullNode == false) {
                            Endpoints secondaryEndpointsInstance = new Endpoints();
                            storageAccountInstance.setSecondaryEndpoints(secondaryEndpointsInstance);
                            
                            JsonNode blobValue2 = secondaryEndpointsValue.get("blob");
                            if (blobValue2 != null && blobValue2 instanceof NullNode == false) {
                                URI blobInstance2;
                                blobInstance2 = new URI(blobValue2.getTextValue());
                                secondaryEndpointsInstance.setBlob(blobInstance2);
                            }
                            
                            JsonNode queueValue2 = secondaryEndpointsValue.get("queue");
                            if (queueValue2 != null && queueValue2 instanceof NullNode == false) {
                                URI queueInstance2;
                                queueInstance2 = new URI(queueValue2.getTextValue());
                                secondaryEndpointsInstance.setQueue(queueInstance2);
                            }
                            
                            JsonNode tableValue2 = secondaryEndpointsValue.get("table");
                            if (tableValue2 != null && tableValue2 instanceof NullNode == false) {
                                URI tableInstance2;
                                tableInstance2 = new URI(tableValue2.getTextValue());
                                secondaryEndpointsInstance.setTable(tableInstance2);
                            }
                        }
                    }
                }
                
            }
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("RetryAfter").length > 0) {
                result.setRetryAfter(DatatypeConverter.parseInt(httpResponse.getFirstHeader("RetryAfter").getValue()));
            }
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            if (statusCode == HttpStatus.SC_CONFLICT) {
                result.setStatus(OperationStatus.Failed);
            }
            if (statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                result.setStatus(OperationStatus.InProgress);
            }
            if (statusCode == HttpStatus.SC_ACCEPTED) {
                result.setStatus(OperationStatus.InProgress);
            }
            if (statusCode == HttpStatus.SC_OK) {
                result.setStatus(OperationStatus.Succeeded);
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
}
