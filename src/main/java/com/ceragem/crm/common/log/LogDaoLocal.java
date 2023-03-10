package com.ceragem.crm.common.log;

import com.ceragem.crm.common.util.Utilities;

/**
 * <pre>
 * com.ceragem.crm.common.log - LogDaoLocal.java
 * </pre>
 *
 * @ClassName : LogDaoLocal
 * @Description : TODO
 * @author : κΉμ±ν
 * @date : 2021. 4. 23.
 * @Version : 1.0
 * @Company : Copyright β wigo.ai. All Right Reserved
 */

public class LogDaoLocal {

	public static ThreadLocal<ChangeLogVo> local = new ThreadLocal<ChangeLogVo>();

	public static ChangeLogVo get() {
		if (local.get() == null) {
			ChangeLogVo vo = new ChangeLogVo();
			vo.setChngCallDt(Utilities.getDateTimeString());
			local.set(vo);
		}
		return local.get();

	}

	public static void clear() {
		local.set(null);

	}

}