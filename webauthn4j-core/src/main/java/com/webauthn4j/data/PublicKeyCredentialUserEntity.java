/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.data;

import com.webauthn4j.util.ArrayUtil;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Objects;

/**
 * {@link PublicKeyCredentialUserEntity} is used to supply additional user account attributes
 * when creating a new credential.
 *
 * @see <a href="https://www.w3.org/TR/webauthn-1/#dictdef-publickeycredentialuserentity">
 * §5.4.3. User Account Parameters for Credential Generation (dictionary PublicKeyCredentialUserEntity)</a>
 */
public class PublicKeyCredentialUserEntity extends PublicKeyCredentialEntity {

    // ~ Instance fields
    // ================================================================================================

    private byte[] id;
    private String displayName;

    /**
     * @param id id
     * @param name name
     * @param displayName displayName
     */
    public PublicKeyCredentialUserEntity(
            @NonNull byte[] id,
            @NonNull String name,
            @NonNull String displayName) {
        super(name);
        this.id = id;
        this.displayName = displayName;
    }

    public @NonNull byte[] getId() {
        return ArrayUtil.clone(id);
    }

    public @NonNull String getDisplayName() {
        return displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PublicKeyCredentialUserEntity that = (PublicKeyCredentialUserEntity) o;
        return Arrays.equals(id, that.id) &&
                Objects.equals(displayName, that.displayName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), displayName);
        result = 31 * result + Arrays.hashCode(id);
        return result;
    }
}
