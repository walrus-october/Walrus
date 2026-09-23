package com.coldfriesinoctober.walrus.music;

import com.coldfriesinoctober.walrus.music.YtMusicApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/coldfriesinoctober/walrus/music/YtStream;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$resolveStream$2$raced$1$deferreds$1$1", f = "YtMusicApi.kt", i = {}, l = {782}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class YtMusicApi$resolveStream$2$raced$1$deferreds$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YtStream>, Object> {
    final /* synthetic */ YtMusicApi.PlayerClient $client;
    final /* synthetic */ Ref.ObjectRef<Exception> $lastError;
    final /* synthetic */ String $videoId;
    final /* synthetic */ String $visitorData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$resolveStream$2$raced$1$deferreds$1$1(String str, YtMusicApi.PlayerClient playerClient, String str2, Ref.ObjectRef<Exception> objectRef, Continuation<? super YtMusicApi$resolveStream$2$raced$1$deferreds$1$1> continuation) {
        super(2, continuation);
        this.$videoId = str;
        this.$client = playerClient;
        this.$visitorData = str2;
        this.$lastError = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YtMusicApi$resolveStream$2$raced$1$deferreds$1$1(this.$videoId, this.$client, this.$visitorData, this.$lastError, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super YtStream> continuation) {
        return ((YtMusicApi$resolveStream$2$raced$1$deferreds$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Exception] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        YtMusicApi$resolveStream$2$raced$1$deferreds$1$1 ytMusicApi$resolveStream$2$raced$1$deferreds$1$1;
        T e;
        YtMusicApi$resolveStream$2$raced$1$deferreds$1$1 ytMusicApi$resolveStream$2$raced$1$deferreds$1$12;
        Object resolveWithClient;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ytMusicApi$resolveStream$2$raced$1$deferreds$1$1 = this;
                try {
                    ytMusicApi$resolveStream$2$raced$1$deferreds$1$1.label = 1;
                    resolveWithClient = YtMusicApi.INSTANCE.resolveWithClient(ytMusicApi$resolveStream$2$raced$1$deferreds$1$1.$videoId, ytMusicApi$resolveStream$2$raced$1$deferreds$1$1.$client, ytMusicApi$resolveStream$2$raced$1$deferreds$1$1.$visitorData, (r12 & 8) != 0, ytMusicApi$resolveStream$2$raced$1$deferreds$1$1);
                    if (resolveWithClient == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = obj;
                    obj = resolveWithClient;
                    try {
                        return (YtStream) obj;
                    } catch (Exception e2) {
                        YtMusicApi$resolveStream$2$raced$1$deferreds$1$1 ytMusicApi$resolveStream$2$raced$1$deferreds$1$13 = ytMusicApi$resolveStream$2$raced$1$deferreds$1$1;
                        e = e2;
                        obj = obj2;
                        ytMusicApi$resolveStream$2$raced$1$deferreds$1$12 = ytMusicApi$resolveStream$2$raced$1$deferreds$1$13;
                        ytMusicApi$resolveStream$2$raced$1$deferreds$1$12.$lastError.element = e;
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    ytMusicApi$resolveStream$2$raced$1$deferreds$1$12 = ytMusicApi$resolveStream$2$raced$1$deferreds$1$1;
                    ytMusicApi$resolveStream$2$raced$1$deferreds$1$12.$lastError.element = e;
                    return null;
                }
            case 1:
                ytMusicApi$resolveStream$2$raced$1$deferreds$1$12 = this;
                try {
                    ResultKt.throwOnFailure(obj);
                    ytMusicApi$resolveStream$2$raced$1$deferreds$1$1 = ytMusicApi$resolveStream$2$raced$1$deferreds$1$12;
                    obj2 = obj;
                    return (YtStream) obj;
                } catch (Exception e4) {
                    e = e4;
                    ytMusicApi$resolveStream$2$raced$1$deferreds$1$12.$lastError.element = e;
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
