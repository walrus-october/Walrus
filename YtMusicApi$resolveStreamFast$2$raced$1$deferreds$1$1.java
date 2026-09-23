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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/coldfriesinoctober/walrus/music/YtStream;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1", f = "YtMusicApi.kt", i = {}, l = {742}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class YtMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YtStream>, Object> {
    final /* synthetic */ YtMusicApi.PlayerClient $client;
    final /* synthetic */ String $videoId;
    final /* synthetic */ String $visitorData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1(String str, YtMusicApi.PlayerClient playerClient, String str2, Continuation<? super YtMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1> continuation) {
        super(2, continuation);
        this.$videoId = str;
        this.$client = playerClient;
        this.$visitorData = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YtMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1(this.$videoId, this.$client, this.$visitorData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super YtStream> continuation) {
        return ((YtMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        YtMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1 ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1;
        YtMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1 ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$12;
        Object resolveWithClient;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1 = this;
                try {
                    ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1.label = 1;
                    resolveWithClient = YtMusicApi.INSTANCE.resolveWithClient(ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1.$videoId, ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1.$client, ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1.$visitorData, false, ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1);
                    if (resolveWithClient == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = obj;
                    obj = resolveWithClient;
                    try {
                        return (YtStream) obj;
                    } catch (Exception e) {
                        obj = obj2;
                        ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$12 = ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1;
                        return null;
                    }
                } catch (Exception e2) {
                    ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$12 = ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1;
                    return null;
                }
            case 1:
                ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$12 = this;
                try {
                    ResultKt.throwOnFailure(obj);
                    ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$1 = ytMusicApi$resolveStreamFast$2$raced$1$deferreds$1$12;
                    obj2 = obj;
                    return (YtStream) obj;
                } catch (Exception e3) {
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
