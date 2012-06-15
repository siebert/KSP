/**
 * Copyright (c) 2012, Daniel Pavel (pwr)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */

package com.amazon.kindle.kindlet.internal;

import pwr.kindlet.Whitelist;
import pwr.kindlet.k410.UnsignedClassLoader;

import java.io.IOException;
import java.net.URL;
import java.security.PermissionCollection;

public class hb extends kb {
	public hb(com.amazon.kindle.kindlet.internal.install.p _app, PermissionCollection _permissions, com.amazon.ebook.framework.service.h _storage,
			  String _devicePid, com.amazon.kindle.kindlet.internal.security.h _certManager) throws KindletLoadException, KindletExecutionException {
		super(_app, _permissions, _storage, _devicePid, _certManager);
	}

	protected com.amazon.kindle.kindlet.internal.security.m BzA(URL[] _urls, PermissionCollection _permissions, String _devicePid,
																com.amazon.kindle.kindlet.internal.security.h _certManager,
																com.amazon.kindle.kindlet.internal.install.p _app) throws KindletLoadException, KindletExecutionException, IOException, ClassNotFoundException {
		if (Whitelist.allows(_app)) {
			System.out.println("allowing unrestricted access for whitelisted Kindlet " + _app.getId() + " from " + _app.we());
			return new UnsignedClassLoader(_urls, _certManager, _app);
		}

		return new com.amazon.kindle.kindlet.internal.security.s(_urls, getClass().getClassLoader(), nyA(), _permissions, _devicePid, _certManager, _app);
	}
}
