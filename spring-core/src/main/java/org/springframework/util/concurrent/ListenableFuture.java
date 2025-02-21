/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.util.concurrent;

import java.util.concurrent.Future;

/**
 * Extend {@link Future} with the capability to accept completion callbacks.
 * If the future has completed when the callback is added, the callback is
 * triggered immediately.
 * <p>Inspired by {@code com.google.common.util.concurrent.ListenableFuture}.
 *
 * @author Arjen Poutsma
 * @author Sebastien Deleuze
 * @since 4.0
 */
public interface ListenableFuture<T> extends Future<T> {

	/**
	 * Register the given {@code ListenableFutureCallback}.
	 * @param callback the callback to register
	 */
	void addCallback(ListenableFutureCallback<? super T> callback);

	/**
	 * Java 8 lambda-friendly alternative with success and failure callbacks.
	 * @param successCallback the success callback
	 * @param failureCallback the failure callback
	 * @since 4.1
	 */
	void addCallback(SuccessCallback<? super T> successCallback, FailureCallback failureCallback);

}
