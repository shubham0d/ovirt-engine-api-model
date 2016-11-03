/*
Copyright (c) 2016 Red Hat, Inc.

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

package services;

import annotations.Area;
import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;
import types.GraphicsConsole;

@Service
@Area("Virtualization")
public interface VmGraphicsConsolesService {

    /**
     * Add new graphics console to the virtual machine.
     *
     * @author Ondra Machacek <omachace@redhat.com>
     * @date 31 Oct 2016
     * @status added
     */
    interface Add {
        @In @Out GraphicsConsole console();
    }

    /**
     * Lists all the configured graphics consoles of the virtual machine.
     *
     * @author Ondra Machacek <omachace@redhat.com>
     * @date 31 Oct 2016
     * @status added
     */
    interface List {

        /**
         * The list of graphics consoles of the virtual machine.
         *
         * @author Ondra Machacek <omachace@redhat.com>
         * @date 31 Oct 2016
         * @status added
         */
        @Out GraphicsConsole[] consoles();

        /**
         * Sets the maximum number of consoles to return. If not specified all the consoles are returned.
         *
         * @author Ondra Machacek <omachace@redhat.com>
         * @date 31 Oct 2016
         * @status added
         */
        @In Integer max();

        /**
         * Use the following query to obtain the current run-time configuration of the graphics consoles.
         *
         * [source]
         * ----
         * GET /ovit-engine/api/vms/123/graphicsconsoles?current=true
         * ----
         *
         * The default value is `false`.
         *
         * @author Ondra Machacek <omachace@redhat.com>
         * @date 31 Oct 2016
         * @status added
         */
        @In Boolean current();
    }

    /**
     * Returns a reference to the service that manages a specific virtual machine graphics console.
     *
     * @author Ondra Machacek <omachace@redhat.com>
     * @date 31 Oct 2016
     * @status added
     */
    @Service VmGraphicsConsoleService console(String id);
}