/*
Copyright (c) 2015 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package services.aaa;

import annotations.Area;
import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.InputDetail;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;
import types.SshPublicKey;

import static org.ovirt.api.metamodel.language.ApiLanguage.mandatory;
import static org.ovirt.api.metamodel.language.ApiLanguage.or;

@Service
@Area("Infrastructure")
public interface SshPublicKeysService {
    interface Add {
        @InputDetail
        default void inputDetail() {
            or(mandatory(key().id()), mandatory(key().name()));
        }
        @In @Out SshPublicKey key();
    }

    /**
     * Returns ths list of SSH public keys of the user.
     *
     * The order of the returned list of keys isn't guaranteed.
     *
     * @author Juan Hernandez <juan.hernandez@redhat.com>
     * @date 15 Apr 2017
     * @status added
     */
    interface List {
        @Out SshPublicKey[] keys();

        /**
         * Sets the maximum number of keys to return. If not specified all the keys are returned.
         */
        @In Integer max();
    }

    @Service SshPublicKeyService key(String id);
}
