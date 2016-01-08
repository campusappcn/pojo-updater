## pojo-updater

[![Release](https://img.shields.io/badge/JitPack-PojoUpdater-red.svg)](https://jitpack.io/#campusappcn/pojo-updater)

[![Release](https://img.shields.io/badge/JitPack-PojoUpdaterCompiler-orange.svg)](https://jitpack.io/#campusappcn/pojo-updater-compiler)

A pojo field updater interface for Android.


Usually we have to maintain a large number of pojos at runtime, updating their fields may be annoying if it has too many fields.

Pojo-updater is trying to solve this problem, just add some annotations and a updater-class will be auto-generated for you.

```Java

// The pojo class
@Updatable
public class Ticket {
	/**
	 * This field can be null since it is annotated with android.support.annotation.Nullable
	 */
	@Nullable 
	public Long mExpire;
	/**
	 * Primary type is directly assigned
	 */
	public long mPurchase;
	/**
	 * This field will be ignored by updater since it is annotated with @Skip
	 */
	@Skip 
	public String mOwnerId;
		private String mId;		
		public String getId() {
       	return mId;
   	}
	    public void setId(String id) {
   	    mId = id;
    }
}

// The generated UpdaterClass:
public final class Ticket$Updater implements Updater<Ticket> {
	@Override
	public void update(final Ticket oldTicket, final Ticket newTicket) {
		if (oldTicket == null) {
			throw new IllegalArgumentException("oldTicket must not be null");
		}
		if (newTicket == null) {
    		throw new IllegalArgumentException("newTicket must not be null");
		}
		oldTicket.mExpire = newTicket.mExpire;
		oldTicket.mPurchase = newTicket.mPurchase;
		if (null != newTicket.getId()) {
   			oldTicket.setId(newTicket.getId());
   		}
	}
}
```

## How to use?

First, add some statements in your root build.gradle:

```groovy

buildscript {
    dependencies {
        ...
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.4'
    }
}

allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}

```

Second, add dependencies

```groovy

dependencies {
		compile 'com.github.campusappcn:pojo-updater:0.1.3'
        apt 'com.github.campusappcn:pojo-updater-compiler:0.1.0'
}
```

License
-------

    Copyright 2015 杭州树洞网络科技有限公司

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.