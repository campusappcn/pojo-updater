## pojo-updater

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
