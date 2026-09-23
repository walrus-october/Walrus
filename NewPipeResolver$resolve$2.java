package com.coldfriesinoctober.walrus.music;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.schabi.newpipe.extractor.MediaFormat;
import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.stream.AudioStream;
import org.schabi.newpipe.extractor.stream.StreamInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewPipeResolver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/coldfriesinoctober/walrus/music/YtStream;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.NewPipeResolver$resolve$2", f = "NewPipeResolver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class NewPipeResolver$resolve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YtStream>, Object> {
    final /* synthetic */ String $videoId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPipeResolver$resolve$2(String str, Continuation<? super NewPipeResolver$resolve$2> continuation) {
        super(2, continuation);
        this.$videoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NewPipeResolver$resolve$2(this.$videoId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super YtStream> continuation) {
        return ((NewPipeResolver$resolve$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object next;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                NewPipeResolver.INSTANCE.ensureInit();
                try {
                    List<AudioStream> audioStreams = StreamInfo.getInfo(ServiceList.YouTube, "https://www.youtube.com/watch?v=" + this.$videoId).getAudioStreams();
                    Intrinsics.checkNotNullExpressionValue(audioStreams, "getAudioStreams(...)");
                    Iterator<T> it = audioStreams.iterator();
                    if (it.hasNext()) {
                        next = it.next();
                        if (it.hasNext()) {
                            AudioStream audioStream = (AudioStream) next;
                            int max = Math.max(audioStream.getAverageBitrate(), audioStream.getBitrate());
                            do {
                                Object next2 = it.next();
                                AudioStream audioStream2 = (AudioStream) next2;
                                int max2 = Math.max(audioStream2.getAverageBitrate(), audioStream2.getBitrate());
                                if (max < max2) {
                                    next = next2;
                                    max = max2;
                                }
                            } while (it.hasNext());
                        }
                    } else {
                        next = null;
                    }
                    AudioStream audioStream3 = (AudioStream) next;
                    if (audioStream3 == null) {
                        throw new IOException("no audio stream for " + this.$videoId);
                    }
                    int max3 = Math.max(audioStream3.getAverageBitrate(), audioStream3.getBitrate());
                    if (1 <= max3 && max3 < 10000) {
                        max3 *= 1000;
                    }
                    String content = audioStream3.getContent();
                    Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
                    MediaFormat format = audioStream3.getFormat();
                    return new YtStream(content, format != null ? format.mimeType : null, max3, MapsKt.mapOf(TuplesKt.to(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0"), TuplesKt.to(HttpHeaders.ORIGIN, "https://www.youtube.com"), TuplesKt.to(HttpHeaders.REFERER, "https://www.youtube.com/watch?v=" + this.$videoId)));
                } catch (Exception e) {
                    throw new IOException("stream extraction failed for " + this.$videoId, e);
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
