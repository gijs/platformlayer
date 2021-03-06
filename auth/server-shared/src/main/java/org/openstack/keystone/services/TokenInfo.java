package org.openstack.keystone.services;

import java.util.Date;

public class TokenInfo {
    public final byte flags;
    public final String scope;
    public final String userId;
    public final Date expiration;
    public final byte[] tokenSecret;

    public static final byte FLAG_SYSTEM = 0x1;

    public TokenInfo(byte flags, String scope, String userId, Date expiration, byte[] tokenSecret) {
        this.flags = flags;
        this.scope = scope;
        this.userId = userId;
        this.expiration = expiration;
        this.tokenSecret = tokenSecret;
    }

    public boolean isSystem() {
        return (flags & FLAG_SYSTEM) != 0;
    }

    public boolean hasExpired() {
        return expiration.getTime() < System.currentTimeMillis();
    }

}
