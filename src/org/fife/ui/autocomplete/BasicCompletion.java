/*
 * 01/03/2009
 *
 * BasicCompletion.java - A straightforward Completion implementation.
 * Copyright (C) 2009 Robert Futrell
 * robert_futrell at users.sourceforge.net
 * http://fifesoft.com/rsyntaxtextarea
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307 USA.
 */
package org.fife.ui.autocomplete;


/**
 * A straightforward completion implementation.  This implementation can be
 * used if you have a relatively short number of static completions with no
 * (or short) summaries.
 *
 * @author Robert Futrell
 * @version 1.0
 */
public class BasicCompletion extends AbstractCompletion {

	private String replacementText;
	private String shortDesc;
	private String summary;


	/**
	 * Constructor.
	 *
	 * @param provider The parent completion provider.
	 * @param replacementText The text to replace.
	 */
	public BasicCompletion(CompletionProvider provider, String replacementText){
		this(provider, replacementText, null, null);
	}


	/**
	 * Constructor.
	 *
	 * @param provider The parent completion provider.
	 * @param replacementText The text to replace.
	 * @param shortDesc A short description of the completion.  This will be
	 *        displayed in the completion list.  This may be <code>null</code>.
	 * @param summary The summary of this completion.  This should be HTML.
	 *        This may be <code>null</code>.
	 */
	public BasicCompletion(CompletionProvider provider, String replacementText,
							String shortDesc, String summary) {
		super(provider);
		this.replacementText = replacementText;
		this.shortDesc = shortDesc;
		this.summary = summary;
	}


	/**
	 * {@inheritDoc}
	 */
	public String getReplacementText() {
		return replacementText;
	}


	/**
	 * {@inheritDoc}
	 */
	public String getSummary() {
		return summary;
	}


	/**
	 * Returns a string representation of this completion.  If the short
	 * description is not <code>null</code>, this method will return:
	 * 
	 * <code>getReplacementText() + " - " + shortDesc</code>
	 * 
	 * otherwise, it will return <tt>getReplacementText()</tt>.
	 *
	 * @return A string representation of this completion.
	 */
	public String toString() {
		if (shortDesc==null) {
			return getReplacementText();
		}
		else {
			return getReplacementText() + " - " + shortDesc;
		}
	}


}