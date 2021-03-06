/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.crypto.provider.hsm.cryptoprovider.exception;

import iaik.pkcs.pkcs11.TokenException;
import org.wso2.carbon.crypto.api.CryptoException;

/**
 * Extension of {@link CryptoException}
 * This exception will be thrown if something unexpected happened during a HSM based crypto operation.
 */
public class HSMCryptoException extends CryptoException {

    private String errorCode;

    /**
     * Default constructor of an exception.
     */
    public HSMCryptoException() {

        super();
    }

    /**
     * Constructor of {@link HSMCryptoException}.
     *
     * @param message : Error message.
     * @param e       : Exception thrown.
     */
    public HSMCryptoException(String message, Throwable e) {

        super(message, e);
        if (e instanceof TokenException) {
            this.errorCode = e.getMessage();
        }
    }

    public String getErrorCode() {

        return this.errorCode;
    }

    protected void setErrorCode(String errorCode) {

        this.errorCode = errorCode;
    }
}
