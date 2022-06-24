//import java.util.UUID;
//import java.util.concurrent.CompletableFuture;
//
//public class Main {
//
//	public static void main(String[] args) throws InterruptedException {
//
//		StitchLogger.configure(new Configuration("StichLogApplication", "Ecommerce", false));
//		StitchLogger.setCorrelationId(UUID.randomUUID().toString());
//		StitchLogger.setTransactionId(UUID.randomUUID().toString());
//		StitchLogger.logInfoStart("START", "Iniciando a aplicação...", null);
//		StitchLogger.info("CURRENT", "Rodando aplicação...", null);
//		StitchLogger.debug("ERROR", "ERRO", null, new RuntimeException("asjdfkasjdfkasjfksjafk"));
//		CompletableFuture<Void> completableFuture = CompletableFuture.allOf(
//				CompletableFuture.runAsync(() -> StitchLogger.info("CURRENT", "Rodando aplicação...", null)),
//				CompletableFuture.runAsync(() -> StitchLogger.info("CURRENT", "Rodando aplicação...", null)));
//		completableFuture.join();
//
//		StitchLogger.logInfoFinish("STOP", "Parando aplicação...", null);
//	}
//
//}
