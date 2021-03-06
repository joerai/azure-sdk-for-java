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

package com.microsoft.azure.keyvault.models;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidParameterException;

//CHECKSTYLE.OFF: InnerAssignmentCheck - More readable than nesting ifs.

public class ObjectIdentifier {

    protected static boolean isObjectIdentifier(String collection, String identifier) {

        collection = verifyNonEmpty(collection, "collection");
        identifier = verifyNonEmpty(identifier, "identifier");

        URI baseUri;
        try {
            baseUri = new URI(identifier);
        } catch (URISyntaxException e) {
            return false;
        }

        // Path is of the form "/collection/name[/version]"
        String[] segments = baseUri.getPath().split("/");
        if (segments.length != 3 && segments.length != 4) {
            return false;
        }

        if (!collection.equals(segments[1])) {
            return false;
        }

        return true;
    }

    private static String verifyNonEmpty(String value, String argName) {
        if (value != null) {
            value = value.trim();
            if (value.isEmpty()) {
                value = null;
            }
        }
        if (value == null) {
            throw new IllegalArgumentException(argName);
        }
        return value;
    }

    private final String vault;
    private final String name;
    private final String version;
    private final String baseIdentifier;
    private final String identifier;

    protected ObjectIdentifier(String vault, String collection, String name) {
        this(vault, collection, name, null);
    }

    protected ObjectIdentifier(String vault, String collection, String name, String version) {

        vault = verifyNonEmpty(vault, "vault");
        collection = verifyNonEmpty(collection, "collection");
        name = verifyNonEmpty(name, "name");

        if (version != null) {
            version = version.trim();
            if (version.isEmpty()) {
                version = null;
            }
        }

        URI baseUri;
        try {
            baseUri = new URI(vault);
        } catch (URISyntaxException e) {
            throw new InvalidParameterException(String.format("Invalid ObjectIdentifier: %s. Not a valid URI", vault));
        }

        this.name = name;
        this.version = version;
        this.vault = String.format("%s://%s", baseUri.getScheme(), getFullAuthority(baseUri));
        baseIdentifier = String.format("%s/%s/%s", this.vault, collection, this.name);
        identifier = version == null ? baseIdentifier : String.format("%s/%s", baseIdentifier, version);
    }

    protected ObjectIdentifier(String collection, String identifier) {

        if (collection == null || collection.length() == 0) {
            throw new IllegalArgumentException("collection");
        }

        if (identifier == null || identifier.length() == 0) {
            throw new IllegalArgumentException("identifier");
        }

        URI baseUri;
        try {
            baseUri = new URI(identifier);
        } catch (URISyntaxException e) {
            throw new InvalidParameterException(String.format("Invalid ObjectIdentifier: %s. Not a valid URI", identifier));
        }

        // Path is of the form "/collection/name[/version]"
        String[] segments = baseUri.getPath().split("/");
        if (segments.length != 3 && segments.length != 4) {
            throw new InvalidParameterException(String.format("Invalid ObjectIdentifier: %s. Bad number of segments: %d", identifier, segments.length));
        }

        if (!collection.equals(segments[1])) {
            throw new InvalidParameterException(String.format("Invalid ObjectIdentifier: %s. segment [1] should be '%s', found '%s'", identifier, collection, segments[1]));
        }

        name = segments[2];
        version = segments.length == 4 ? segments[3] : null;
        vault = String.format("%s://%s", baseUri.getScheme(), getFullAuthority(baseUri));
        baseIdentifier = String.format("%s/%s/%s", vault, collection, name);
        this.identifier = version == null ? baseIdentifier : String.format("%s/%s", baseIdentifier, version);
    }

    private static String getFullAuthority(URI uri) {
        String authority = uri.getAuthority();
        if (!authority.contains(":") && uri.getPort() > 0) {
            // Append port for complete authority
            authority = String.format("%s:%d", uri.getAuthority(), uri.getPort());
        }
        return authority;
    }

    /**
     * The base identifier for an object, does not include the object version.
     */
    public String getBaseIdentifier() {
        return baseIdentifier;
    }

    /**
     * The identifier for an object, includes the objects version.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * The name of the object.
     */
    public String getName() {
        return name;
    }

    /**
     * The vault containing the object
     */
    public String getVault() {
        return vault;
    }

    /**
     * The version of the object.
     */
    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
