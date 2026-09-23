package com.coldfriesinoctober.walrus.music;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Spotify.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.Spotify$apiWrite$2", f = "Spotify.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class Spotify$apiWrite$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends String>>, Object> {
    final /* synthetic */ String $method;
    final /* synthetic */ String $path;
    final /* synthetic */ String $token;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Spotify$apiWrite$2(String str, String str2, String str3, Continuation<? super Spotify$apiWrite$2> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$token = str2;
        this.$method = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Spotify$apiWrite$2(this.$path, this.$token, this.$method, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Integer, String>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Integer, String>> continuation) {
        return ((Spotify$apiWrite$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OkHttpClient okHttpClient;
        Object awaitBody;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Request build = new Request.Builder().url("https://api.spotify.com/v1" + this.$path).header(HttpHeaders.AUTHORIZATION, "Bearer " + this.$token).method(this.$method, RequestBody.INSTANCE.create("{}", MediaType.INSTANCE.get("application/json"))).build();
                Spotify spotify = Spotify.INSTANCE;
                okHttpClient = Spotify.http;
                this.label = 1;
                awaitBody = spotify.awaitBody(okHttpClient.newCall(build), this);
                return awaitBody == coroutine_suspended ? coroutine_suspended : awaitBody;
            case 1:
                ResultKt.throwOnFailure(obj);
                return obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
