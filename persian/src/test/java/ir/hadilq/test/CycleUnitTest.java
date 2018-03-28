package ir.hadilq.test;

import org.junit.Test;

import ir.hadilq.util.Cycle;

public class CycleUnitTest {

    private static final int BASE_YEAR = 1349;
    private static final boolean[] SAMPLE_LEAP_YEARS = new boolean[]{
            false, //  1349
            true,  // 1350
            false, // False   ,  1351
            false, // False   ,  1352
            false, // False   ,  1353
            true, // True   ,  1354
            false, // False   ,  1355
            false, // False   ,  1356
            false, // False   ,  1357
            true, // True   ,  1358
            false, // False   ,  1359
            false, // False   ,  1360
            false, // False   ,  1361
            true, // True   ,  1362
            false, // False   ,  1363
            false, // False   ,  1364
            false, // False   ,  1365
            true, // True   ,  1366
            false, // False   ,  1367
            false, // False   ,  1368
            false, // False   ,  1369
            true, // True   ,  1370
            false, // False   ,  1371
            false, // False   ,  1372
            false, // False   ,  1373
            false, // False   ,  1374
            true, // True   ,  1375
            false, // False   ,  1376
            false, // False   ,  1377
            false, // False   ,  1378
            true, // True   ,  1379
            false, // False   ,  1380
            false, // False   ,  1381
            false, // False   ,  1382
            true, // True   ,  1383
            false, // False   ,  1384
            false, // False   ,  1385
            false, // False   ,  1386
            true, // True   ,  1387
            false, // False   ,  1388
            false, // False   ,  1389
            false, // False   ,  1390
            true, // True   ,  1391
            false, // False   ,  1392
            false, // False   ,  1393
            false, // False   ,  1394
            true, // True   ,  1395
            false, // False   ,  1396
            false, // False   ,  1397
            false, // False   ,  1398
            true, // True   ,  1399
            false, // False   ,  1400
            false, // False   ,  1401
            false, // False   ,  1402
            false, // False   ,  1403
            true, // True   ,  1404
            false, // False   ,  1405
            false, // False   ,  1406
            false, // False   ,  1407
            true, // True   ,  1408
            false, // False   ,  1409
            false, // False   ,  1410
            false, // False   ,  1411
            true, // True   ,  1412
            false, // False   ,  1413
            false, // False   ,  1414
            false, // False   ,  1415
            true, // True   ,  1416
            false, // False   ,  1417
    };


    @Test
    public void isCycleWorkingCompareToSample() throws Exception {
        Cycle bigCycle = new Cycle();
        for (int i = 0; i < SAMPLE_LEAP_YEARS.length; i++) {
            if (SAMPLE_LEAP_YEARS[i] ^ Cycle.isLeap(bigCycle, BASE_YEAR + i, true)) {
                throw new Exception("Sample: " + SAMPLE_LEAP_YEARS[i] + ", cycle: " +
                        Cycle.isLeap(bigCycle, BASE_YEAR + i, true));
            }
        }
    }
}
