# Argomenti trattati
- Ripasso sugli Interceptors di Spring
- Abilitare un interceptor tramite variabile d'ambiente

# Esercizio 1
Fare in modo che SupplierHeaderInterceptor venga eseguito solo sugli URI contenenti /fruits/ tramite il metodo *excludePathPatterns(...)*.

# Esercizio 2
Aggiungere l'oggetto *Supplier* relativo alla chiave identificativa nell'header come attributo della richiesta HTTP (*request.setAttribute(...)*). 

# Esercizio 3
Aggiungere all'entità *Supplier* un campo *deliveredQuantity* di tipo intero che indichi la quantità di frutta consegnata dal fornitore.
Fare in modo che questo valore venga aggiornato ad ogni richiesta POST in /fruits/.

Implementare un interceptor *SupplierQuantityInterceptor* che ad ogni richiesta aggiunga un header alla risposta *X-Total-Delivered-Quantity* che indica quanta frutta il supplier ha consegnato fino a quel momento, **dopo che la richiesta è stata elaborata dal controller**.

# Esercizio 4
Scrivere integration test per FruitController e SupplierController.
